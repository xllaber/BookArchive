package com.llacerximo.booklist.persistence.impl;

import com.llacerximo.booklist.common.dto.GenreDTO;
import com.llacerximo.booklist.domain.repository.GenreRepository;
import com.llacerximo.booklist.persistence.dao.GenreDao;
import com.llacerximo.booklist.persistence.mapper.GenrePersistenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GenreRepositoryImpl implements GenreRepository {

    @Autowired
    GenreDao genreDao;

    @Override
    public List<GenreDTO> findAll() {
        return GenrePersistenceMapper.mapper.toGenreDTOList(this.genreDao.findAll());
    }

    @Override
    public Optional<GenreDTO> findById(Long id) {
        return Optional.of(GenrePersistenceMapper.mapper.toGenreDTO(this.genreDao.findById(id).get()));
    }

    @Override
    public GenreDTO save(GenreDTO genreDTO) {
        return GenrePersistenceMapper.mapper.toGenreDTO(
                this.genreDao.save(
                    GenrePersistenceMapper.mapper.toGenreEntity(genreDTO)
                )
        );
    }

    @Override
    public void delete(Long id) {
        this.genreDao.deleteById(id);
    }

}
