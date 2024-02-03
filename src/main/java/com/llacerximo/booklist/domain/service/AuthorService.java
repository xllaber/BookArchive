package com.llacerximo.booklist.domain.service;

import com.llacerximo.booklist.common.dto.AuthorDTO;

import java.util.List;

public interface AuthorService {

    List<AuthorDTO> findAll();
    List<AuthorDTO> findAllByName(String search);
    AuthorDTO findById(Long id);
    AuthorDTO insert(AuthorDTO authorDTO);
    AuthorDTO update(AuthorDTO authorDTO);
    void delete(Long id);

}
