package com.llacerximo.booklist.controller.model.author;

import com.llacerximo.booklist.controller.model.pseudonym.PseudonymWeb;
import lombok.*;

import java.util.List;

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
    List<PseudonymWeb> pseudonyms;

}
