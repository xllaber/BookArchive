package com.llacerximo.booklist.domain.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
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
    String image;
    Saga saga;
    Pseudonym author;
    List<Reread> rereads;
    List<Genre> genres;

}
