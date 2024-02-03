package com.llacerximo.booklist.controller.mapper;

import com.llacerximo.booklist.common.dto.RereadDTO;
import com.llacerximo.booklist.controller.model.reread.RereadListWeb;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RereadWebMapper {

    RereadWebMapper mapper = Mappers.getMapper(RereadWebMapper.class);

    RereadListWeb toRereadListWeb(RereadDTO rereadDTO);
    List<RereadListWeb> toRereadListWebList(List<RereadDTO> rereadDTOList);

}
