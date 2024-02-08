package com.llacerximo.booklist.domain.repository;

import com.llacerximo.booklist.common.dto.GenreDTO;

import java.util.List;
import java.util.Optional;

public interface GenreRepository {

    List<GenreDTO> findAll();
    List<GenreDTO> findAllById(List<Long> ids);
    Optional<GenreDTO> findById(Long id);
    GenreDTO save(GenreDTO genreDTO);
    void delete(Long id);

}
