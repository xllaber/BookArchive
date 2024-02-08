package com.llacerximo.booklist.common.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class BookCreateDTO {

    Long id;
    String title;
    Integer pages;
    Integer publishYear;
    Double sagaNum;
    Boolean fave;
    String image;
    Long sagaId;
    List<Long> authorIds;
    RereadDTO rereadDTO;
    List<Long> genreIds;

}
