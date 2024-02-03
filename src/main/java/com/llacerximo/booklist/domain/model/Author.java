package com.llacerximo.booklist.domain.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

    Long id;
    String name;
    String country;
    Integer birthYear;
    Integer deathYear;
    String image;

}
