package com.llacerximo.booklist.domain.repository;

import com.llacerximo.booklist.common.dto.BookDTO;
import com.llacerximo.booklist.common.dto.SagaDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookRepository {

    List<BookDTO> findAllByFinishDate(Integer year);
    List<BookDTO> findAll();
    List<BookDTO> findAllByFaveTrue();
    List<BookDTO> findAllBySagaId(Long id);
    List<BookDTO> findLastFiveRead();
    Optional<BookDTO> findById(Long id);
    BookDTO save(BookDTO bookDTO);
    void delete(Long id);
}
