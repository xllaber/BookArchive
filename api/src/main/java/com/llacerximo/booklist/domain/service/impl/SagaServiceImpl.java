package com.llacerximo.booklist.domain.service.impl;

import com.llacerximo.booklist.common.dto.SagaDTO;
import com.llacerximo.booklist.common.exception.ResourceNotFoundException;
import com.llacerximo.booklist.domain.mapper.SagaDomainMapper;
import com.llacerximo.booklist.domain.model.Saga;
import com.llacerximo.booklist.domain.repository.SagaRepository;
import com.llacerximo.booklist.domain.service.SagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SagaServiceImpl implements SagaService {

    @Autowired
    SagaRepository sagaRepository;

    @Override
    public List<SagaDTO> findAll() {
        List<SagaDTO> sagaDTOS = this.sagaRepository.findAll();
        return SagaDomainMapper.mapper.toSagaDTOList(SagaDomainMapper.mapper.toSagaList(sagaDTOS));
    }

    @Override
    public List<SagaDTO> findByName(String search) {
        List<SagaDTO> sagaDTOS = this.sagaRepository.findByName(search);
        return SagaDomainMapper.mapper.toSagaDTOList(SagaDomainMapper.mapper.toSagaList(sagaDTOS));
    }

    @Override
    public SagaDTO findById(Long id) {
        SagaDTO sagaDTO = this.sagaRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No se ha encontrado la saga con id: " + id));
        return SagaDomainMapper.mapper.toSagaDTO(SagaDomainMapper.mapper.toSaga(sagaDTO));
    }

    @Override
    public SagaDTO insert(SagaDTO sagaDTO) {
        //TODO: check publishYear > Author.birthYear
        Saga saga = SagaDomainMapper.mapper.toSaga(sagaDTO);
        return this.sagaRepository.save(SagaDomainMapper.mapper.toSagaDTO(saga));
    }

    @Override
    public SagaDTO update(SagaDTO sagaDTO) {
        //TODO: check publishYear > Author.birthYear
        Saga saga = SagaDomainMapper.mapper.toSaga(
            this.sagaRepository.findById(sagaDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("La saga que intentas actualizar no existe. Id: " + sagaDTO.getId()))
        );
        SagaDomainMapper.mapper.updateSagaFromSagaDTO(sagaDTO, saga);
        return this.sagaRepository.save(SagaDomainMapper.mapper.toSagaDTO(saga));
    }

    @Override
    public void delete(Long id) {
        SagaDTO sagaDTO = this.sagaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("La saga que intentas borrar no existe. Id: " + id));
        Saga saga = SagaDomainMapper.mapper.toSaga(sagaDTO);
        this.sagaRepository.delete(SagaDomainMapper.mapper.toSagaDTO(saga));
    }

}
