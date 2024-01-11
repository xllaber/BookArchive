package com.llacerximo.booklist.persistence.impl;

import com.llacerximo.booklist.common.dto.SagaDTO;
import com.llacerximo.booklist.domain.repository.SagaRepository;

import java.util.List;
import java.util.Optional;

public class SagaRepositoryImpl implements SagaRepository {

    @Override
    public List<SagaDTO> findAll() {
        return null;
    }

    @Override
    public List<SagaDTO> findByName() {
        return null;
    }

    @Override
    public Optional<SagaDTO> findById(Long id) {
        return Optional.empty();
    }

}
