package com.llacerximo.booklist.persistence.mapper;

import com.llacerximo.booklist.common.dto.AuthorDTO;
import com.llacerximo.booklist.persistence.model.AuthorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorPersistenceMapper {

    AuthorPersistenceMapper mapper = Mappers.getMapper(AuthorPersistenceMapper.class);

    AuthorEntity toAuthorEntity(AuthorDTO authorDTO);
    List<AuthorEntity> toAuthorEntityList(List<AuthorDTO> authorDTOList);
    AuthorDTO toAuthorDTO(AuthorEntity authorEntity);
    List<AuthorDTO> toAuthorDTOList(List<AuthorEntity> authorEntities);

}
