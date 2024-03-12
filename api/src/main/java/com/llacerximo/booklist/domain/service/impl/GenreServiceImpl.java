package com.llacerximo.booklist.domain.service.impl;

import com.llacerximo.booklist.common.dto.GenreDTO;
import com.llacerximo.booklist.common.exception.ResourceNotFoundException;
import com.llacerximo.booklist.domain.mapper.GenreDomainMapper;
import com.llacerximo.booklist.domain.model.Genre;
import com.llacerximo.booklist.domain.repository.GenreRepository;
import com.llacerximo.booklist.domain.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    GenreRepository genreRepository;

    @Override
    public List<GenreDTO> findAll() {
        return GenreDomainMapper.mapper.toGenreDTOList(
                GenreDomainMapper.mapper.toGenreList(this.genreRepository.findAll())
        );
    }

    @Override
    public GenreDTO findById(Long id) {
        return GenreDomainMapper.mapper.toGenreDTO(
            GenreDomainMapper.mapper.toGenre(
                this.genreRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Genero no encontrado. ID: " + id ))
            )
        );
    }

    @Override
    public GenreDTO insert(GenreDTO genreDTO) {
        return GenreDomainMapper.mapper.toGenreDTO(
                GenreDomainMapper.mapper.toGenre(
                    this.genreRepository.save(genreDTO)
                )
        );
    }

    @Override
    public GenreDTO update(GenreDTO genreDTO) {
        Genre genre = GenreDomainMapper.mapper.toGenre(
            this.genreRepository.findById(genreDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Genero no encontrado. ID: " + genreDTO.getId()))
        );
        GenreDomainMapper.mapper.updateGenreFromGenreDTO(genreDTO, genre);
        return this.genreRepository.save(GenreDomainMapper.mapper.toGenreDTO(genre));
    }

    @Override
    public void delete(Long id) {
        this.genreRepository.delete(id);
    }
}
