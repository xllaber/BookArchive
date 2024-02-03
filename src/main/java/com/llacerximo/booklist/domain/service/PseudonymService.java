package com.llacerximo.booklist.domain.service;

import com.llacerximo.booklist.common.dto.PseudonymDTO;

import java.util.List;
import java.util.Optional;

public interface PseudonymService {

    List<PseudonymDTO> findAll();
    Optional<PseudonymDTO> findByName(String search);
    Optional<PseudonymDTO> findById(Long id);
    Optional<PseudonymDTO> findByBookId(Long bookId);

}
