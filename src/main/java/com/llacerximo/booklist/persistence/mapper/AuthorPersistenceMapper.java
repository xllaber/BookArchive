package com.llacerximo.booklist.persistence.mapper;

import com.llacerximo.booklist.common.dto.AuthorDTO;
import com.llacerximo.booklist.persistence.model.AuthorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorPersistenceMapper {

    AuthorPersistenceMapper mapper = Mappers.getMapper(AuthorPersistenceMapper.class);

    @Mapping(target = "pseudonymEntities", expression = "java(PseudonymPersistenceMapper.mapper.toPseudonymEntityList(authorDTO.getPseudonyms()))")
    AuthorEntity toAuthorEntity(AuthorDTO authorDTO);
    List<AuthorEntity> toAuthorEntityList(List<AuthorDTO> authorDTOList);
    @Mapping(target = "pseudonyms", expression = "java(PseudonymPersistenceMapper.mapper.toPseudonymDTOList(authorEntity.getPseudonymEntities()))")
    AuthorDTO toAuthorDTO(AuthorEntity authorEntity);
    List<AuthorDTO> toAuthorDTOList(List<AuthorEntity> authorEntities);

}
