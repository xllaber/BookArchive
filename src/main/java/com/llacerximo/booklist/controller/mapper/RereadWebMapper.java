package com.llacerximo.booklist.controller.mapper;

import com.llacerximo.booklist.common.dto.RereadDTO;
import com.llacerximo.booklist.controller.model.reread.RereadResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RereadWebMapper {

    RereadWebMapper mapper = Mappers.getMapper(RereadWebMapper.class);

    RereadResponse toRereadResponse(RereadDTO rereadDTO);
    List<RereadResponse> toRereadResponseList(List<RereadDTO> rereadDTOList);

    RereadDTO toRereadDTO(RereadResponse rereadResponse);
    List<RereadDTO> toRereadDTOList(List<RereadResponse> rereadListWebList);

}
