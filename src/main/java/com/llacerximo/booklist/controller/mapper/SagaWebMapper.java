package com.llacerximo.booklist.controller.mapper;

import com.llacerximo.booklist.common.dto.SagaDTO;
import com.llacerximo.booklist.controller.model.saga.SagaListWeb;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SagaWebMapper {

    SagaWebMapper mapper = Mappers.getMapper(SagaWebMapper.class);

    SagaListWeb toSagaListWeb(SagaDTO sagaDTO);
    List<SagaListWeb> toSagaListWebList(List<SagaDTO> sagaDTOList);

    SagaDTO toSagaDTO(SagaListWeb sagaListWeb);
    List<SagaDTO> toSagaDTO(List<SagaListWeb> sagaListWeb);

}
