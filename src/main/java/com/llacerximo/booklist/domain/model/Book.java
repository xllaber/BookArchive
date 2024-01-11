package com.llacerximo.booklist.domain.model;

import com.llacerximo.booklist.common.enums.GenreEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    Long id;
    String title;
    Integer pages;
    Integer publishYear;
    Double sagaNum;
    Boolean fave;
    Date startDate;
    Date finishDate;
    String image;
    Saga saga;
    Pseudonym author;
    List<Reread> rereads;
    List<GenreEnum> genres;

}
