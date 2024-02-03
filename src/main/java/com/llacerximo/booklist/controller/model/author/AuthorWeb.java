package com.llacerximo.booklist.controller.model.author;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorWeb {

    Long id;
    String name;
    String country;
    Integer birthYear;
    Integer deathYear;
    String image;

}
