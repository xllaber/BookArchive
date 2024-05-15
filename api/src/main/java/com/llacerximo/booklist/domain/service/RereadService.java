package com.llacerximo.booklist.domain.service;

import com.llacerximo.booklist.common.dto.RereadDTO;

public interface RereadService {

    RereadDTO getById(Long id);
    RereadDTO insert(RereadDTO rereadDTO);
    RereadDTO update(RereadDTO rereadDTO);

}
