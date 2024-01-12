package com.llacerximo.booklist.domain.service.impl;

import com.llacerximo.booklist.common.dto.BookDTO;
import com.llacerximo.booklist.common.exception.ResourceNotFoundException;
import com.llacerximo.booklist.domain.mapper.BookDomainMapper;
import com.llacerximo.booklist.domain.model.Book;
import com.llacerximo.booklist.domain.repository.BookRepository;
import com.llacerximo.booklist.domain.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

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
        Book book = BookDomainMapper.mapper.toBook(bookDTO);
        BookDTO bookDTO1 = BookDomainMapper.mapper.toBookDTO(book);
        return bookDTO1;
    }

}
