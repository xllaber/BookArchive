package com.llacerximo.booklist.domain.service.impl;

import com.llacerximo.booklist.common.dto.BookCreateDTO;
import com.llacerximo.booklist.common.dto.BookDTO;
import com.llacerximo.booklist.common.dto.SagaDTO;
import com.llacerximo.booklist.common.exception.EntityValidationException;
import com.llacerximo.booklist.common.exception.ResourceNotFoundException;
import com.llacerximo.booklist.domain.mapper.*;
import com.llacerximo.booklist.domain.model.Author;
import com.llacerximo.booklist.domain.model.Book;
import com.llacerximo.booklist.domain.model.Genre;
import com.llacerximo.booklist.domain.model.Saga;
import com.llacerximo.booklist.domain.repository.*;
import com.llacerximo.booklist.domain.service.BookService;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    PseudonymRepository pseudonymRepository;
    @Autowired
    SagaRepository sagaRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    GenreRepository genreRepository;

    @Override
    public List<BookDTO> findAllByFinishDate(Integer year) {
        List<BookDTO> bookDTOS = this.bookRepository.findAllByFinishDate(year);
        List<Book> books = BookDomainMapper.mapper.toBookList(bookDTOS);
        List<BookDTO> bookDTOList = BookDomainMapper.mapper.toBookDtoList(books);
        return bookDTOList;
    }

    @Override
    public BookDTO findById(Long id) {
        BookDTO bookDTO = this.bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se ha encontrado el libro con id: " + id));
        Book book = BookDomainMapper.mapper.toBookWithGenres(bookDTO);
        BookDTO bookDTO1 = BookDomainMapper.mapper.toBookDTOWithGenres(book);
        return bookDTO1;
    }

    @Override
    public BookDTO insert(BookCreateDTO bookCreateDTO) {
        Saga saga = SagaDomainMapper.mapper.toSaga(
            this.sagaRepository.findById(bookCreateDTO.getSagaId()).orElse(null)
        );

        Book book = Book.builder()
                .authors(
                    AuthorDomainMapper.mapper.toAuthorList(
                        this.authorRepository.findAllById(bookCreateDTO.getAuthorIds())
                    )
                )
                .genres(
                    GenreDomainMapper.mapper.toGenreList(
                        this.genreRepository.findAllById(bookCreateDTO.getGenreIds())
                    )
                )
                .fave(bookCreateDTO.getFave())
                .saga(saga)
                .pages(bookCreateDTO.getPages())
                .image(bookCreateDTO.getImage())
                .title(bookCreateDTO.getTitle())
                .rereads(bookCreateDTO.getRereadDTO() != null ?
                    List.of(RereadDomainMapper.mapper.toReread(bookCreateDTO.getRereadDTO())) : null
                )
                .build();
        if (validatePublishYear(book.getAuthors(), bookCreateDTO, saga)) {
            book.setPublishYear(bookCreateDTO.getPublishYear());
        }
        if (saga != null) {
            if (this.validateSagaNum(saga, bookCreateDTO.getSagaNum(), false))
                book.setSagaNum(bookCreateDTO.getSagaNum());
        }
        BookDTO bookDTO = BookDomainMapper.mapper.toBookDTOWithGenres(book);
        return this.bookRepository.save(bookDTO);

    }

    @Override
    public BookDTO update(BookCreateDTO bookCreateDTO) {
        Book existingBook = BookDomainMapper.mapper.toBookWithGenres(
            this.bookRepository.findById(bookCreateDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("El libro que intentas actualizar no existe. ID: " + bookCreateDTO.getId()))
        );
        List<Author> authors = AuthorDomainMapper.mapper.toAuthorList(
                this.authorRepository.findAllById(bookCreateDTO.getAuthorIds())
        );
        List<Genre> genres = GenreDomainMapper.mapper.toGenreList(
                this.genreRepository.findAllById(bookCreateDTO.getGenreIds())
        );
        if (bookCreateDTO.getSagaId() != null) {
            Saga saga = this.findSaga(bookCreateDTO.getSagaId());
            if (saga != null) {
                if (this.validatePublishYear(authors, bookCreateDTO, saga))
                    existingBook.setPublishYear(bookCreateDTO.getPublishYear());

                if (this.validateSagaNum(saga, bookCreateDTO.getSagaNum(), true))
                    existingBook.setSagaNum(bookCreateDTO.getSagaNum());

                existingBook.setSaga(saga);
            }
        }
        existingBook.setPublishYear(bookCreateDTO.getPublishYear());
        existingBook.setPages(bookCreateDTO.getPages());
        existingBook.setFave(bookCreateDTO.getFave());
        existingBook.setImage(bookCreateDTO.getImage() != null ? bookCreateDTO.getImage() : null);
        existingBook.setGenres(genres);
        existingBook.setAuthors(authors);
        existingBook.setTitle(bookCreateDTO.getTitle());

        return this.bookRepository.save(BookDomainMapper.mapper.toBookDTOWithGenres(existingBook));
    }

    @Override
    public void delete(Long id) {
        this.bookRepository.delete(id);
    }

    private boolean validateSagaNum(Saga saga, Double sagaNum, boolean isUpdate) {
        List<Book> booksOfSaga = BookDomainMapper.mapper.toBookList(this.bookRepository.findAllBySagaId(saga.getId()));
        List<Book> books = new ArrayList<>();
        if (isUpdate) {
            books = booksOfSaga.stream().filter(b -> !b.getSagaNum().equals(sagaNum)).toList();
        }

        books.forEach(book -> {
            if (sagaNum.equals(book.getSagaNum()))
                throw new EntityValidationException("No puede haber dos libros con el mismo numero dentro de una saga");
        });
        return true;
    }

    private boolean validatePublishYear(List<Author> authors,BookCreateDTO bookCreateDTO, Saga saga) {
        if (bookCreateDTO.getRereadDTO() != null &&
                bookCreateDTO.getRereadDTO().getStartDate().getYear() < bookCreateDTO.getPublishYear()) {
            throw new EntityValidationException("Un libro no puede haber sido leído antes de que se publique"
                + " Fecha libro: " + bookCreateDTO.getPublishYear() + " Fecha lectura: " +  bookCreateDTO.getRereadDTO().getStartDate());
        }
        authors.forEach(a -> {
            if (a != null && a.getBirthYear() > bookCreateDTO.getPublishYear())
                throw new EntityValidationException("El año de publicacion no puede ser anterior al nacimiento del autor");
        });
        if (bookCreateDTO.getPublishYear() < saga.getPublishStart())
            throw new EntityValidationException("Un libro de una saga no puede haber sido publicado antes que la saga"
                    + " Fecha libro: " + bookCreateDTO.getPublishYear() + " Fecha saga: " +  saga.getPublishStart());
        return true;
    }

    private Saga findSaga(Long sagaId) {
        SagaDTO sagaDTO = this.sagaRepository.findById(sagaId)
                .orElseThrow(() -> new ResourceNotFoundException("La saga que estas intentando actualizar no existe. ID: " + sagaId));
        return SagaDomainMapper.mapper.toSaga(sagaDTO);
    }

}
