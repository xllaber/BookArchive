package com.llacerximo.booklist.domain.repository;

import com.llacerximo.booklist.common.dto.PseudonymDTO;

import java.util.List;
import java.util.Optional;

public interface PseudonymRepository {

    Optional<PseudonymDTO> findById(Long id);
    PseudonymDTO save(PseudonymDTO pseudonymDTO);
    void delete(Long id);

}
