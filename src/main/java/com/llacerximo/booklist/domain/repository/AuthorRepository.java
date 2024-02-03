package com.llacerximo.booklist.domain.repository;

import com.llacerximo.booklist.common.dto.AuthorDTO;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {

    List<AuthorDTO> findAll();
    List<AuthorDTO> findAllByName(String search);
    Optional<AuthorDTO> findById();
    Optional<AuthorDTO> findByName(String name);

}
