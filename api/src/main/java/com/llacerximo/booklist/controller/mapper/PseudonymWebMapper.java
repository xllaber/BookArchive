package com.llacerximo.booklist.controller.mapper;

import com.llacerximo.booklist.common.dto.PseudonymDTO;
import com.llacerximo.booklist.controller.model.pseudonym.PseudonymRequest;
import com.llacerximo.booklist.controller.model.pseudonym.PseudonymResponse;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PseudonymWebMapper {

    PseudonymWebMapper mapper = Mappers.getMapper(PseudonymWebMapper.class);

    PseudonymResponse toPseudonymResponse(PseudonymDTO pseudonymDTO);
    List<PseudonymResponse> toPseudonymResponseList(List<PseudonymDTO> pseudonymDTOList);

    PseudonymDTO toPseudonymDTO(PseudonymRequest pseudonymRequest);
    List<PseudonymDTO> toPseudonymDTOList(List<PseudonymRequest> pseudonymRequests);

}
