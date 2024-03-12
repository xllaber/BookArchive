package com.llacerximo.booklist.domain.service;

import com.llacerximo.booklist.common.dto.PseudonymDTO;

import java.util.List;
import java.util.Optional;

public interface PseudonymService {

    PseudonymDTO findById(Long id);
    PseudonymDTO insert(PseudonymDTO pseudonymDTO);
    PseudonymDTO update(PseudonymDTO pseudonymDTO);
    void delete(Long id);

}
