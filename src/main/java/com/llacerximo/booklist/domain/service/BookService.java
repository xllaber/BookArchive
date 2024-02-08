package com.llacerximo.booklist.domain.service;

import com.llacerximo.booklist.common.dto.BookCreateDTO;
import com.llacerximo.booklist.common.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> findAllByFinishDate(Integer year);
    BookDTO findById(Long id);
    BookDTO insert(BookCreateDTO bookCreateDTO);
    BookDTO update(BookCreateDTO bookCreateDTO);
    void delete(Long id);
}
