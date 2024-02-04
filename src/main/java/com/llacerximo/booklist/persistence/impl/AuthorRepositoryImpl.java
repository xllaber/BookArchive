package com.llacerximo.booklist.persistence.impl;

import com.llacerximo.booklist.common.dto.AuthorDTO;
import com.llacerximo.booklist.domain.model.Author;
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
        return AuthorPersistenceMapper.mapper.toAuthorDTOList(this.authorDao.findAll());
    }

    @Override
    public List<AuthorDTO> findAllByName(String name) {
        return AuthorPersistenceMapper.mapper.toAuthorDTOList(this.authorDao.findAllByNameContainingIgnoreCase(name));
    }

    @Override
    public Optional<AuthorDTO> findById(Long id) {
        return Optional.of(
            AuthorPersistenceMapper.mapper.toAuthorDTO(
                this.authorDao.findById(id).get()
            )
        );
    }

    @Override
    public AuthorDTO save(AuthorDTO authorDTO) {
        //TODO: crear insert pseudonym y usarlo antes de este
        return AuthorPersistenceMapper.mapper.toAuthorDTO(
            this.authorDao.save(
                AuthorPersistenceMapper.mapper.toAuthorEntity(authorDTO)
            )
        );
    }


}
