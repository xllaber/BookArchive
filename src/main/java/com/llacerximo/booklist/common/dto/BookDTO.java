package com.llacerximo.booklist.common.dto;

import com.llacerximo.booklist.common.enums.GenreEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class BookDTO {

    Long id;
    String title;
    Integer pages;
    Integer publishYear;
    Double sagaNum;
    Boolean fave;
    Date startDate;
    Date finishDate;
    String image;
    SagaDTO saga;
    PseudonymDTO author;
    List<RereadDTO> rereads;
    List<GenreEnum> genres;

}
