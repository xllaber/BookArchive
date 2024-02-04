package com.llacerximo.booklist.controller.mapper;

import com.llacerximo.booklist.common.dto.AuthorDTO;
import com.llacerximo.booklist.controller.model.author.AuthorRequest;
import com.llacerximo.booklist.controller.model.author.AuthorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorWebMapper {

    AuthorWebMapper mapper = Mappers.getMapper(AuthorWebMapper.class);

    @Mapping(target = "pseudonyms", expression = "java(PseudonymWebMapper.mapper.toPseudonymResponseList(authorDTO.getPseudonyms()))")
    AuthorResponse toAuthorResponse(AuthorDTO authorDTO);
    List<AuthorResponse> toAuthorResponseList(List<AuthorDTO> authorDTOList);

    @Mapping(target = "pseudonyms", expression = "java(PseudonymWebMapper.mapper.toPseudonymDTOList(authorRequest.getPseudonyms()))")
    AuthorDTO toAuthorDTO(AuthorRequest authorRequest);
    List<AuthorDTO> toAuthorDTOList(List<AuthorRequest> authorRequestList);

}
