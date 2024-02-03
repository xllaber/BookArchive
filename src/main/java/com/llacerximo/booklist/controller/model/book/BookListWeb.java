package com.llacerximo.booklist.controller.model.book;

import com.llacerximo.booklist.controller.model.reread.RereadListWeb;
import com.llacerximo.booklist.domain.model.Pseudonym;
import com.llacerximo.booklist.domain.model.Saga;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BookListWeb {

    Long id;
    String title;
    Integer pages;
    Integer publishYear;
    Double sagaNum;
    Boolean fave;
    String image;
    Saga saga;
    Pseudonym author;
    List<RereadListWeb> rereads;
//    List<GenreEnum> genres;

}
