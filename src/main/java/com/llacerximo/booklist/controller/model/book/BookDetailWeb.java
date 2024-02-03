package com.llacerximo.booklist.controller.model.book;

import com.llacerximo.booklist.controller.model.author.AuthorWeb;
import com.llacerximo.booklist.controller.model.genre.GenreWeb;
import com.llacerximo.booklist.controller.model.reread.RereadListWeb;
import com.llacerximo.booklist.controller.model.saga.SagaListWeb;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BookDetailWeb {

    Long id;
    String title;
    Integer pages;
    Integer publishYear;
    Double sagaNum;
    Boolean fave;
    String image;
    SagaListWeb saga;
    List<AuthorWeb> authors;
    List<RereadListWeb> rereads;
    List<GenreWeb> genres;

}
