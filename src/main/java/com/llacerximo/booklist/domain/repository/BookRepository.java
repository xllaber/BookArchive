package com.llacerximo.booklist.domain.repository;

import com.llacerximo.booklist.common.dto.BookDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookRepository {

    List<BookDTO> findAllByFinishDate(Integer year);
    List<BookDTO> findAllByFaveTrue();
    List<BookDTO> findAllByPseudonymId(Long id);
    List<BookDTO> findAllBySagaId(Long id);
    List<BookDTO> findLastFiveRead();
    Optional<BookDTO> findById(Long id);
    Optional<BookDTO> findByName(String search);

}
