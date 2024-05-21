package com.llacerximo.booklist.domain.repository;

import com.llacerximo.booklist.common.dto.SagaDTO;

import java.util.List;
import java.util.Optional;

public interface SagaRepository {

    List<SagaDTO> findAll();
    List<SagaDTO> findByName(String search);
    Optional<SagaDTO> findById(Long id);
    SagaDTO save(SagaDTO sagaDTO);
    void delete(SagaDTO sagaDTO);

}
