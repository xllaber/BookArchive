package com.llacerximo.booklist.domain.repository;

import com.llacerximo.booklist.common.dto.RereadDTO;

import java.util.List;

public interface RereadRepository {

    List<RereadDTO> findAll();

}
