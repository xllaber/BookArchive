package com.llacerximo.booklist.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class AuthorDTO {

    Long id;
    String name;
    String country;
    Integer birthYear;
    Integer deathYear;
    String image;

}
