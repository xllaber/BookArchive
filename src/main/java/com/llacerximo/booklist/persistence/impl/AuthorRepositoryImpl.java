package com.llacerximo.booklist.persistence.impl;

import com.llacerximo.booklist.common.dto.AuthorDTO;
import com.llacerximo.booklist.domain.repository.AuthorRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    @Override
    public List<AuthorDTO> findAll() {
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
