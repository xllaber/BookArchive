package com.llacerximo.booklist.persistence.dao;

import com.llacerximo.booklist.persistence.model.SagaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SagaDao extends JpaRepository<SagaEntity, Long> {

    List<SagaEntity> findAllByNameContainingIgnoreCase(String search);
    void deleteById(Long id);

}
