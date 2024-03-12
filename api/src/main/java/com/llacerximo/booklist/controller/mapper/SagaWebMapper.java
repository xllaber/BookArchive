package com.llacerximo.booklist.controller.mapper;

import com.llacerximo.booklist.common.dto.SagaDTO;
import com.llacerximo.booklist.controller.model.saga.SagaRequest;
import com.llacerximo.booklist.controller.model.saga.SagaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SagaWebMapper {

    SagaWebMapper mapper = Mappers.getMapper(SagaWebMapper.class);

    SagaResponse toSagaResponse(SagaDTO sagaDTO);
    List<SagaResponse> toSagaResponseList(List<SagaDTO> sagaDTOList);

    SagaDTO toSagaDTO(SagaRequest sagaRequest);
    List<SagaDTO> toSagaDTO(List<SagaRequest> sagaRequests);

}
