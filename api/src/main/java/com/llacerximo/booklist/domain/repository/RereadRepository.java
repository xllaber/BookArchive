package com.llacerximo.booklist.domain.repository;

import com.llacerximo.booklist.common.dto.RereadDTO;

import java.util.List;
import java.util.Optional;

public interface RereadRepository {

    List<RereadDTO> findAll();
    Optional<RereadDTO> getById(Long id);
    RereadDTO save(RereadDTO rereadDTO);

}
