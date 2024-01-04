package com.llacerximo.booklist.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookEntity {

    Long id;
    String name;
    Integer pages;
    Double sagaNum;
    Boolean fave;
    Date publishDate;
    Date startDate;
    Date finishDate;

    Long sagaId;
    List<Long> genreIds;

}
