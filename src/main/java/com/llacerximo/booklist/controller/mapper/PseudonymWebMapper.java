package com.llacerximo.booklist.controller.mapper;

import com.llacerximo.booklist.common.dto.PseudonymDTO;
import com.llacerximo.booklist.controller.model.pseudonym.PseudonymWeb;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PseudonymWebMapper {

    PseudonymWebMapper mapper = Mappers.getMapper(PseudonymWebMapper.class);

    PseudonymWeb toPseudonymWeb(PseudonymDTO pseudonymDTO);
    List<PseudonymWeb> toPseudonymWebList(List<PseudonymDTO> pseudonymDTOList);

    PseudonymDTO toPseudonymDTO(PseudonymWeb pseudonymWeb);
    List<PseudonymDTO> toPseudonymDTOList(List<PseudonymWeb> pseudonymWeb);

}
