package com.llacerximo.booklist.domain.repository;

import com.llacerximo.booklist.common.dto.PseudonymDTO;

import java.util.List;
import java.util.Optional;

public interface PseudonymRepository {

    List<PseudonymDTO> findAll();
    Optional<PseudonymDTO> findByName(String search);
    Optional<PseudonymDTO> findById(Long id);

    Optional<PseudonymDTO> findByBookId(Long bookId);

}
