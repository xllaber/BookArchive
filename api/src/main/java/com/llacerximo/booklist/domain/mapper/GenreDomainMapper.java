package com.llacerximo.booklist.domain.mapper;

import com.llacerximo.booklist.common.dto.GenreDTO;
import com.llacerximo.booklist.domain.model.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreDomainMapper {

    GenreDomainMapper mapper = Mappers.getMapper(GenreDomainMapper.class);

    Genre toGenre(GenreDTO genreDTO);
    List<Genre> toGenreList(List<GenreDTO> genreDTOList);
    GenreDTO toGenreDTO(Genre genre);
    List<GenreDTO> toGenreDTOList(List<Genre> genreList);
    void updateGenreFromGenreDTO(GenreDTO genreDTO, @MappingTarget Genre genre);

}
