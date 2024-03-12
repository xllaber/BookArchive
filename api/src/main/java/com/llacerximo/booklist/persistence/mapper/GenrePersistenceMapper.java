package com.llacerximo.booklist.persistence.mapper;

import com.llacerximo.booklist.common.dto.GenreDTO;
import com.llacerximo.booklist.domain.model.Genre;
import com.llacerximo.booklist.persistence.model.GenreEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenrePersistenceMapper {

    GenrePersistenceMapper mapper = Mappers.getMapper(GenrePersistenceMapper.class);

    GenreEntity toGenreEntity(GenreDTO genreDTO);
    List<GenreEntity> toGenreEntityList(List<GenreDTO> genreDTO);
    GenreDTO toGenreDTO(GenreEntity genreEntity);
    List<GenreDTO> toGenreDTOList(List<GenreEntity> genreEntity);

}
