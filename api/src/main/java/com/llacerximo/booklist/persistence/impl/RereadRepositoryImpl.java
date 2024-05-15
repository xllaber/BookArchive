package com.llacerximo.booklist.persistence.impl;

import com.llacerximo.booklist.common.dto.RereadDTO;
import com.llacerximo.booklist.domain.repository.RereadRepository;
import com.llacerximo.booklist.persistence.dao.RereadDao;
import com.llacerximo.booklist.persistence.mapper.RereadPersistenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RereadRepositoryImpl implements RereadRepository {

    @Autowired
    RereadDao rereadDao;

    @Override
    public List<RereadDTO> findAll() {
        return null;
    }

    @Override
    public Optional<RereadDTO> getById(Long id) {
        return Optional.of(
                RereadPersistenceMapper.mapper.toRereadDTO(
                        this.rereadDao.findById(id).get()
                )
        );
    }

    @Override
    public RereadDTO save(RereadDTO rereadDTO) {
        return RereadPersistenceMapper.mapper.toRereadDTO(
                this.rereadDao.save(RereadPersistenceMapper.mapper.toRereadEntity(rereadDTO))
        );
    }

}
