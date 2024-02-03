package com.llacerximo.booklist.controller.mapper;

import com.llacerximo.booklist.common.dto.AuthorDTO;
import com.llacerximo.booklist.controller.model.author.AuthorWeb;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorWebMapper {

    AuthorWebMapper mapper = Mappers.getMapper(AuthorWebMapper.class);

    AuthorWeb toAuthorWeb(AuthorDTO authorDTO);
    AuthorDTO toAuthorDTO(AuthorWeb authorWeb);
    List<AuthorWeb> toAuthorWebList(List<AuthorDTO> authorDTOList);
    List<AuthorDTO> toAuthorDTOList(List<AuthorWeb> authorWebList);

}
