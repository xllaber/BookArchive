package com.llacerximo.booklist.persistence.impl;

import com.llacerximo.booklist.common.dto.AuthorDTO;
import com.llacerximo.booklist.common.dto.PseudonymDTO;
import com.llacerximo.booklist.domain.model.Author;
import com.llacerximo.booklist.domain.repository.AuthorRepository;
import com.llacerximo.booklist.persistence.dao.AuthorDao;
import com.llacerximo.booklist.persistence.dao.PseudonymDao;
import com.llacerximo.booklist.persistence.mapper.AuthorPersistenceMapper;
import com.llacerximo.booklist.persistence.mapper.PseudonymPersistenceMapper;
import com.llacerximo.booklist.persistence.model.AuthorEntity;
import com.llacerximo.booklist.persistence.model.PseudonymEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    @Autowired
    AuthorDao authorDao;
    @Autowired
    PseudonymDao pseudonymDao;

    @Override
    public List<AuthorDTO> findAll() {
        return AuthorPersistenceMapper.mapper.toAuthorDTOList(this.authorDao.findAll());
    }

    @Override
    public List<AuthorDTO> findAllByName(String name) {
        return AuthorPersistenceMapper.mapper.toAuthorDTOList(this.authorDao.findAllByNameContainingIgnoreCase(name));
    }

    @Override
    public List<AuthorDTO> findAllById(List<Long> ids) {
        return AuthorPersistenceMapper.mapper.toAuthorDTOList(this.authorDao.findAllById(ids));
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
    @Transactional
    public AuthorDTO save(AuthorDTO authorDTO) {
//        List<PseudonymEntity> pseudonymEntities = this.pseudonymDao.saveAll(
//            PseudonymPersistenceMapper.mapper.toPseudonymEntityList(authorDTO.getPseudonyms())
//        );
        AuthorEntity author = this.authorDao.save(
            AuthorPersistenceMapper.mapper.toAuthorEntity(authorDTO)
        );
//        author.setPseudonymEntities(pseudonymEntities);
        return AuthorPersistenceMapper.mapper.toAuthorDTO(author);
    }

    @Override
    public void delete(Long id) {
        this.authorDao.deleteById(id);
    }


}
