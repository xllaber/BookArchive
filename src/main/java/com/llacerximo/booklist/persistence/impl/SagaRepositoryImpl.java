package com.llacerximo.booklist.persistence.impl;

import com.llacerximo.booklist.common.dto.SagaDTO;
import com.llacerximo.booklist.domain.repository.SagaRepository;
import com.llacerximo.booklist.persistence.dao.SagaDao;
import com.llacerximo.booklist.persistence.mapper.SagaPersistenceMapper;
import com.llacerximo.booklist.persistence.model.SagaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SagaRepositoryImpl implements SagaRepository {

    @Autowired
    SagaDao sagaDao;

    @Override
    public List<SagaDTO> findAll() {
        return SagaPersistenceMapper.mapper.toSagaDTOList(this.sagaDao.findAll());
    }

    @Override
    public List<SagaDTO> findByName(String search) {
        return SagaPersistenceMapper.mapper.toSagaDTOList(this.sagaDao.findAllByNameContainingIgnoreCase(search));
    }

    @Override
    public Optional<SagaDTO> findById(Long id) {
        Optional<SagaEntity> saga = this.sagaDao.findById(id);
        return Optional.of(SagaPersistenceMapper.mapper.toSagaDTO(saga.get()));
    }

    @Override
    public SagaDTO save(SagaDTO sagaDTO) {
        SagaEntity saga = SagaPersistenceMapper.mapper.toSagaEntity(sagaDTO);
        SagaDTO sagaDTO1 = SagaPersistenceMapper.mapper.toSagaDTO(this.sagaDao.save(saga));
        return sagaDTO1;
    }

    @Override
    public void delete(SagaDTO sagaDTO) {
        this.sagaDao.delete(SagaPersistenceMapper.mapper.toSagaEntity(sagaDTO));
    }

}
