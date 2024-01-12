package com.llacerximo.booklist.controller.model.book;

import com.llacerximo.booklist.common.enums.GenreEnum;
import com.llacerximo.booklist.domain.model.Pseudonym;
import com.llacerximo.booklist.domain.model.Reread;
import com.llacerximo.booklist.domain.model.Saga;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class BookListWeb {

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
//    List<Reread> rereads;
//    List<GenreEnum> genres;

}
