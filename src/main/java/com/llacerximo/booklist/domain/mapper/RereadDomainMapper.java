package com.llacerximo.booklist.domain.mapper;

import com.llacerximo.booklist.common.dto.RereadDTO;
import com.llacerximo.booklist.domain.model.Reread;
import com.llacerximo.booklist.persistence.mapper.RereadPersistenceMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RereadDomainMapper {

    RereadDomainMapper mapper = Mappers.getMapper(RereadDomainMapper.class);

    Reread toReread(RereadDTO rereadDTO);
    List<Reread> toRereadList(List<RereadDTO> rereadDTOList);
    RereadDTO toRereadDTO(Reread reread);
    List<RereadDTO> toRereadDTOList(List<RereadDTO> rereadDTOList);

}
