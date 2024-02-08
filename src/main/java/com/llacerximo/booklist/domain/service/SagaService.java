package com.llacerximo.booklist.domain.service;

import com.llacerximo.booklist.common.dto.SagaDTO;

import java.util.List;

public interface SagaService {

    List<SagaDTO> findAll();
    List<SagaDTO> findByName(String search);
    SagaDTO findById(Long id);
    SagaDTO insert(SagaDTO sagaDTO);
    SagaDTO update(SagaDTO sagaDTO);
    void delete(Long id);

}
