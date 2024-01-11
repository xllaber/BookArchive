package com.llacerximo.booklist.domain.repository;

import com.llacerximo.booklist.common.dto.SagaDTO;

import java.util.List;
import java.util.Optional;

public interface SagaRepository {

    List<SagaDTO> findAll();
    List<SagaDTO> findByName();
    Optional<SagaDTO> findById(Long id);

}
