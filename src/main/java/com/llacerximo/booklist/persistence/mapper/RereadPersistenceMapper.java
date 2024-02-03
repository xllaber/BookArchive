package com.llacerximo.booklist.persistence.mapper;

import com.llacerximo.booklist.common.dto.RereadDTO;
import com.llacerximo.booklist.persistence.model.RereadEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RereadPersistenceMapper {

    RereadPersistenceMapper mapper = Mappers.getMapper(RereadPersistenceMapper.class);

    RereadEntity toRereadEntity(RereadDTO rereadDTO);
    List<RereadEntity> toRereadEntityList(List<RereadDTO> rereadDTOList);
    RereadDTO toRereadDTO(RereadEntity rereadEntity);
    List<RereadDTO> toRereadDTOList(List<RereadEntity> rereadEntityList);

}
