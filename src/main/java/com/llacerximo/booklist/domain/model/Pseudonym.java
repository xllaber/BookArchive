package com.llacerximo.booklist.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pseudonym {

    Long id;
    String pseudonym;
    List<Author> authors;

}
