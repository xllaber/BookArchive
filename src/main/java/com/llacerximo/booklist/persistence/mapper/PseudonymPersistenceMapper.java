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

    PseudonymEntity toPseudonymEntity(PseudonymDTO pseudonymDTO);
    List<PseudonymEntity> toPseudonymEntityList(List<PseudonymDTO> pseudonymDTOList);
    PseudonymDTO toPseudonymDTO(PseudonymEntity pseudonymEntity);
    List<PseudonymDTO> toPseudonymDTOList(List<PseudonymEntity> pseudonymEntityList);

}
