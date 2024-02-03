package com.llacerximo.booklist.domain.model;

import com.llacerximo.booklist.common.dto.PseudonymDTO;
import lombok.*;

import java.util.List;

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
    List<Pseudonym> pseudonyms;

}
