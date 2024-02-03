package com.llacerximo.booklist.domain.mapper;

import com.llacerximo.booklist.common.dto.PseudonymDTO;
import com.llacerximo.booklist.domain.model.Pseudonym;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PseudonymDomainMapper {

    PseudonymDomainMapper mapper = Mappers.getMapper(PseudonymDomainMapper.class);

    @Mapping(target = "authors", expression = "java(AuthorDomainMapper.mapper.toAuthorList(pseudonymDTO.getAuthorDTOS()))")
    Pseudonym toPseudonym(PseudonymDTO pseudonymDTO);

    @Mapping(target = "authors", expression = "java(AuthorDomainMapper.mapper.toAuthorList(pseudonymDTO.getAuthorDTOS()))")
    List<Pseudonym> toPseudonymList(List<PseudonymDTO> pseudonymDTOList);
    @Mapping(target = "authorDTOS", expression = "java(AuthorDomainMapper.mapper.toAuthorDTOList(pseudonym.getAuthors()))")
    PseudonymDTO toPseudonymDTO(Pseudonym pseudonym);
    @Mapping(target = "authorDTOS", expression = "java(AuthorDomainMapper.mapper.toAuthorList(pseudonymDTO.getAuthorDTOS()))")
    List<PseudonymDTO> toPseudonymDTOList(List<Pseudonym> pseudonymList);

}
