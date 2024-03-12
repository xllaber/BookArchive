package com.llacerximo.booklist.controller.model.book;

import com.llacerximo.booklist.controller.model.author.AuthorResponse;
import com.llacerximo.booklist.controller.model.genre.GenreResponse;
import com.llacerximo.booklist.controller.model.reread.RereadResponse;
import com.llacerximo.booklist.controller.model.saga.SagaResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BookResponse {

    Long id;
    String title;
    Integer pages;
    Integer publishYear;
    Double sagaNum;
    Boolean fave;
    String image;
    SagaResponse saga;
    List<AuthorResponse> authors;
    List<RereadResponse> rereads;
    List<GenreResponse> genres;

}
