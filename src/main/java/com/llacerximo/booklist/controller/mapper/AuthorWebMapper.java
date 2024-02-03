package com.llacerximo.booklist.controller.mapper;

import com.llacerximo.booklist.common.dto.AuthorDTO;
import com.llacerximo.booklist.controller.model.author.AuthorWeb;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorWebMapper {

    AuthorWebMapper mapper = Mappers.getMapper(AuthorWebMapper.class);

    @Mapping(target = "pseudonyms", expression = "java(PseudonymWebMapper.mapper.toPseudonymWebList(authorDTO.getPseudonyms()))")
    AuthorWeb toAuthorWeb(AuthorDTO authorDTO);
    List<AuthorWeb> toAuthorWebList(List<AuthorDTO> authorDTOList);

    @Mapping(target = "pseudonyms", expression = "java(PseudonymWebMapper.mapper.toPseudonymDTOList(authorWeb.getPseudonyms()))")
    AuthorDTO toAuthorDTO(AuthorWeb authorWeb);
    List<AuthorDTO> toAuthorDTOList(List<AuthorWeb> authorWebList);

}
