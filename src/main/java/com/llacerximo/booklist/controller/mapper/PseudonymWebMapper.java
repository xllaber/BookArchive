package com.llacerximo.booklist.controller.mapper;

import com.llacerximo.booklist.common.dto.PseudonymDTO;
import com.llacerximo.booklist.controller.model.pseudonym.PseudonymListWeb;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PseudonymWebMapper {

    PseudonymWebMapper mapper = Mappers.getMapper(PseudonymWebMapper.class);

    PseudonymListWeb toPseudonymListWeb(PseudonymDTO pseudonymDTO);

}
