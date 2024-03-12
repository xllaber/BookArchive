package com.llacerximo.booklist.domain.mapper;

import com.llacerximo.booklist.common.dto.PseudonymDTO;
import com.llacerximo.booklist.domain.model.Pseudonym;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PseudonymDomainMapper {

    PseudonymDomainMapper mapper = Mappers.getMapper(PseudonymDomainMapper.class);

    Pseudonym toPseudonym(PseudonymDTO pseudonymDTO);
    List<Pseudonym> toPseudonymList(List<PseudonymDTO> pseudonymDTOList);
    PseudonymDTO toPseudonymDTO(Pseudonym pseudonym);
    List<PseudonymDTO> toPseudonymDTOList(List<Pseudonym> pseudonymList);
    void updatePseudonymFromPseudonymDTO(PseudonymDTO pseudonymDTO, @MappingTarget Pseudonym pseudonym);

}
