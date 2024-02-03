package com.llacerximo.booklist.controller.mapper;

import com.llacerximo.booklist.common.dto.GenreDTO;
import com.llacerximo.booklist.controller.model.genre.GenreWeb;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreWebMapper {

    GenreWebMapper mapper = Mappers.getMapper(GenreWebMapper.class);

    GenreWeb toGenreWeb(GenreDTO genreDTO);
    List<GenreWeb> toGenreWebList(List<GenreDTO> genreDTOS);
    GenreDTO toGenreDTO(GenreWeb genreWeb);
    List<GenreDTO> toGenreDTOList(List<GenreWeb> genreWeb);

}
