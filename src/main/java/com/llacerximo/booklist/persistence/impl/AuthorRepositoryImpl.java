package com.llacerximo.booklist.persistence.impl;

import com.llacerximo.booklist.common.dto.AuthorDTO;
import com.llacerximo.booklist.domain.repository.AuthorRepository;
import com.llacerximo.booklist.persistence.dao.AuthorDao;
import com.llacerximo.booklist.persistence.mapper.AuthorPersistenceMapper;
import com.llacerximo.booklist.persistence.model.AuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    @Autowired
    AuthorDao authorDao;

    @Override
    public List<AuthorDTO> findAll() {
        List<AuthorEntity> authorEntities = this.authorDao.findAll();
        List<AuthorDTO> authorDTOList = AuthorPersistenceMapper.mapper.toAuthorDTOList(authorEntities);
        return authorDTOList;
    }

    @Override
    public List<AuthorDTO> findAllByName(String search) {
        return null;
    }

    @Override
    public Optional<AuthorDTO> findById() {
        return Optional.empty();
    }

    @Override
    public Optional<AuthorDTO> findByName(String name) {
        return Optional.empty();
    }

}
