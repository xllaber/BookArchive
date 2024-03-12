package com.llacerximo.booklist.controller.mapper;

import com.llacerximo.booklist.common.dto.GenreDTO;
import com.llacerximo.booklist.controller.model.genre.GenreRequest;
import com.llacerximo.booklist.controller.model.genre.GenreResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreWebMapper {

    GenreWebMapper mapper = Mappers.getMapper(GenreWebMapper.class);

    GenreResponse toGenreResponse(GenreDTO genreDTO);
    List<GenreResponse> toGenreResponseList(List<GenreDTO> genreDTOS);
    GenreDTO toGenreDTO(GenreRequest genreRequest);
    List<GenreDTO> toGenreDTOList(List<GenreResponse> genreResponse);

}
