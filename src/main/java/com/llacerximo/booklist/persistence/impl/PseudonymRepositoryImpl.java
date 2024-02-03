package com.llacerximo.booklist.persistence.impl;

import com.llacerximo.booklist.common.dto.PseudonymDTO;
import com.llacerximo.booklist.domain.repository.PseudonymRepository;
import com.llacerximo.booklist.persistence.dao.PseudonymDao;
import com.llacerximo.booklist.persistence.mapper.PseudonymPersistenceMapper;
import com.llacerximo.booklist.persistence.model.PseudonymEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PseudonymRepositoryImpl implements PseudonymRepository {

    @Autowired
    PseudonymDao pseudonymDao;

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

    @Override
    public Optional<PseudonymDTO> findByBookId(Long bookId) {
        PseudonymEntity pseudonymEntity = this.pseudonymDao.findByBookEntityId(bookId).get();
        PseudonymDTO pseudonymDTO = PseudonymPersistenceMapper.mapper.toPseudonymDTO(pseudonymEntity);
        return Optional.of(pseudonymDTO);
    }

}
