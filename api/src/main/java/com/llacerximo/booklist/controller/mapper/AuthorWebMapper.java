package com.llacerximo.booklist.controller.mapper;

import com.llacerximo.booklist.common.dto.AuthorDTO;
import com.llacerximo.booklist.controller.model.author.AuthorCreateRequest;
import com.llacerximo.booklist.controller.model.author.AuthorResponse;
import com.llacerximo.booklist.controller.model.author.AuthorUpdateRequest;
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

    @Mapping(target = "pseudonyms", expression = "java(PseudonymWebMapper.mapper.toPseudonymDTOList(authorCreateRequest.getPseudonyms()))")
    AuthorDTO toAuthorDTOFromCreateRequest(AuthorCreateRequest authorCreateRequest);
    @Mapping(target = "pseudonyms", ignore = true)
    AuthorDTO toAuthorDTOFromUpdateRequest(AuthorUpdateRequest authorUpdateRequest);
    List<AuthorDTO> toAuthorDTOList(List<AuthorCreateRequest> authorCreateRequestList);

}
