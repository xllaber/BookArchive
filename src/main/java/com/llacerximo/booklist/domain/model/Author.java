package com.llacerximo.booklist.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

    Long id;
    String name;
    String country;
    Date birthYear;
    Date deathYear;
    Byte[] image;

}
