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
    public Optional<PseudonymDTO> findById(Long id) {
        return Optional.of(
            PseudonymPersistenceMapper.mapper.toPseudonymDTO(
                this.pseudonymDao.findById(id).get()
            )
        );
    }

    @Override
    public PseudonymDTO save(PseudonymDTO pseudonymDTO) {
        return PseudonymPersistenceMapper.mapper.toPseudonymDTO(
            this.pseudonymDao.save(
                    PseudonymPersistenceMapper.mapper.toPseudonymEntity(pseudonymDTO)
            )
        );
    }

    @Override
    public void delete(Long id) {
        this.pseudonymDao.deleteById(id);
    }

}
