package com.llacerximo.booklist.controller.model.author;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthorUpdateRequest {

    Long id;
    String name;
    String country;
    Integer birthYear;
    Integer deathYear;
    String image;

}
