package com.llacerximo.booklist.persistence.impl;

import com.llacerximo.booklist.common.dto.PseudonymDTO;
import com.llacerximo.booklist.domain.repository.PseudonymRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PseudonymRepositoryImpl implements PseudonymRepository {

    @Override
    public List<PseudonymDTO> findAll() {
        return null;
    }

    @Override
    public Optional<PseudonymDTO> findByName(String search) {
        return Optional.empty();
    }

    @Override
    public Optional<PseudonymDTO> findById(Long id) {
        return Optional.empty();
    }

}
