package com.llacerximo.booklist.persistence.mapper;

import com.llacerximo.booklist.common.dto.SagaDTO;
import com.llacerximo.booklist.persistence.model.SagaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SagaPersistenceMapper {

    SagaPersistenceMapper mapper = Mappers.getMapper(SagaPersistenceMapper.class);

    SagaEntity toSagaEntity(SagaDTO sagaDTO);
    List<SagaEntity> toSagaEntityList(List<SagaDTO> sagaDTOList);
    SagaDTO toSagaDTO(SagaEntity sagaEntity);
    List<SagaDTO> toSagaDTOList(List<SagaEntity> sagaEntityList);

}
