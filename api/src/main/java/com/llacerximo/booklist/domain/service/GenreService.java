package com.llacerximo.booklist.domain.service;

import com.llacerximo.booklist.common.dto.GenreDTO;
import com.llacerximo.booklist.domain.model.Genre;

import java.util.List;

public interface GenreService {

    List<GenreDTO> findAll();
    GenreDTO findById(Long id);
    GenreDTO insert(GenreDTO genreDTO);
    GenreDTO update(GenreDTO genreDTO);
    void delete(Long id);

}
