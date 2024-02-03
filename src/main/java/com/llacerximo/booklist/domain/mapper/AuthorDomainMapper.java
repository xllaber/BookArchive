package com.llacerximo.booklist.domain.mapper;

import com.llacerximo.booklist.common.dto.AuthorDTO;
import com.llacerximo.booklist.domain.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorDomainMapper {

    AuthorDomainMapper mapper = Mappers.getMapper(AuthorDomainMapper.class);

    @Mapping(target = "pseudonyms", expression = "java(PseudonymDomainMapper.mapper.toPseudonymList(authorDTO.getPseudonyms()))")
    Author toAuthor(AuthorDTO authorDTO);
    List<Author> toAuthorList(List<AuthorDTO> authorDTOList);
    @Mapping(target = "pseudonyms", expression = "java(PseudonymDomainMapper.mapper.toPseudonymDTOList(author.getPseudonyms()))")
    AuthorDTO toAuthorDTO(Author author);
    List<AuthorDTO> toAuthorDTOList(List<Author> authors);

}
