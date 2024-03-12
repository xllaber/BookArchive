package com.llacerximo.booklist.domain.mapper;

import com.llacerximo.booklist.common.dto.SagaDTO;
import com.llacerximo.booklist.domain.model.Saga;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SagaDomainMapper {

    SagaDomainMapper mapper = Mappers.getMapper(SagaDomainMapper.class);

    Saga toSaga(SagaDTO sagaDTO);
    List<Saga> toSagaList(List<SagaDTO> sagaDTOList);
    SagaDTO toSagaDTO(Saga saga);
    List<SagaDTO> toSagaDTOList(List<Saga> sagaList);
    void updateSagaFromSagaDTO(SagaDTO sagaDTO, @MappingTarget Saga saga);

}
