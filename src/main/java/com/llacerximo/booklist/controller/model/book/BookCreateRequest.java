package com.llacerximo.booklist.controller.model.book;

import com.llacerximo.booklist.controller.model.reread.RereadCreateRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class BookCreateRequest {

    Long id;
    String title;
    Integer pages;
    Integer publishYear;
    Double sagaNum;
    Boolean fave;
    String image;
    Long sagaId;
    List<Long> authorIds;
    RereadCreateRequest rereadCreateRequest;
    List<Long> genreIds;

}
