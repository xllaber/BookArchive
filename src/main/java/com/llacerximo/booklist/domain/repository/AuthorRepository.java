package com.llacerximo.booklist.domain.repository;

import com.llacerximo.booklist.common.dto.AuthorDTO;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {

    List<AuthorDTO> findAll();
    List<AuthorDTO> findAllByName(String name);
    List<AuthorDTO> findAllById(List<Long> ids);
    Optional<AuthorDTO> findById(Long id);
    AuthorDTO save(AuthorDTO authorDTO);
    void delete(Long id);

}
