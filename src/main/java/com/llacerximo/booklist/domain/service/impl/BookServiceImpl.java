package com.llacerximo.booklist.domain.service.impl;

import com.llacerximo.booklist.common.dto.BookDTO;
import com.llacerximo.booklist.common.dto.PseudonymDTO;
import com.llacerximo.booklist.common.exception.ResourceNotFoundException;
import com.llacerximo.booklist.domain.mapper.BookDomainMapper;
import com.llacerximo.booklist.domain.mapper.PseudonymDomainMapper;
import com.llacerximo.booklist.domain.model.Book;
import com.llacerximo.booklist.domain.model.Pseudonym;
import com.llacerximo.booklist.domain.repository.BookRepository;
import com.llacerximo.booklist.domain.repository.PseudonymRepository;
import com.llacerximo.booklist.domain.service.BookService;
import com.llacerximo.booklist.persistence.mapper.PseudonymPersistenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    PseudonymRepository pseudonymRepository;

    @Override
    public List<BookDTO> findAllByFinishDate(Integer year) {
        List<BookDTO> bookDTOS = this.bookRepository.findAllByFinishDate(year);
        List<Book> books = BookDomainMapper.mapper.toBookList(bookDTOS);
//        books.stream().forEach(b -> {
//            Pseudonym pseudonym = PseudonymDomainMapper.mapper.toPseudonym(
//                pseudonymRepository.findByBookId(b.getId())
//                    .orElseThrow(
//                        () -> new ResourceNotFoundException("No se ha encontrado el autor del libro con id: " + b.getId())
//                    )
//            );
//            b.setAuthor(pseudonym);
//        });
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
    public BookDTO insert(BookDTO bookDTO) {
        //TODO: check publishYear > Author.birthYear
        return null;
    }

    @Override
    public BookDTO update(BookDTO bookDTO) {
        //TODO: check publishYear > Author.birthYear
        return null;
    }

}
