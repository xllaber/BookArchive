package com.llacerximo.booklist.controller.mapper;

import com.llacerximo.booklist.common.dto.PseudonymDTO;
import com.llacerximo.booklist.controller.model.pseudonym.PseudonymResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PseudonymWebMapper {

    PseudonymWebMapper mapper = Mappers.getMapper(PseudonymWebMapper.class);

    PseudonymResponse toPseudonymResponse(PseudonymDTO pseudonymDTO);
    List<PseudonymResponse> toPseudonymResponseList(List<PseudonymDTO> pseudonymDTOList);

    PseudonymDTO toPseudonymDTO(PseudonymResponse pseudonymResponse);
    List<PseudonymDTO> toPseudonymDTOList(List<PseudonymResponse> pseudonymResponse);

}
