package com.llacerximo.booklist.persistence.mapper;

import com.llacerximo.booklist.common.dto.PseudonymDTO;
import com.llacerximo.booklist.persistence.model.PseudonymEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PseudonymPersistenceMapper {

    PseudonymPersistenceMapper mapper = Mappers.getMapper(PseudonymPersistenceMapper.class);

//    @Mapping(target = "authorEntities", expression = "java(AuthorPersistenceMapper.mapper.toAuthorEntityList(pseudonymDTO.getAuthorDTOS()))")
    PseudonymEntity toPseudonymEntity(PseudonymDTO pseudonymDTO);
//    @Mapping(target = "authorEntities", expression = "java(AuthorPersistenceMapper.mapper.toAuthorEntityList(pseudonymDTO.getAuthorDTOS()))")
    List<PseudonymEntity> toPseudonymEntityList(List<PseudonymDTO> pseudonymDTOList);
//    @Mapping(target = "authorDTOS", expression = "java(AuthorPersistenceMapper.mapper.toAuthorDTOList(pseudonymEntity.getAuthorEntities()))")
    PseudonymDTO toPseudonymDTO(PseudonymEntity pseudonymEntity);
//    @Mapping(target = "authorDTOS", expression = "java(AuthorPersistenceMapper.mapper.toAuthorDTOList(pseudonymEntity.getAuthorEntities()))")
    List<PseudonymDTO> toPseudonymDTOList(List<PseudonymEntity> pseudonymEntityList);

}
