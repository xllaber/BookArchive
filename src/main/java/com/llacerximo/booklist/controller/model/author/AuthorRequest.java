package com.llacerximo.booklist.controller.model.author;

import com.llacerximo.booklist.controller.model.pseudonym.PseudonymRequest;
import com.llacerximo.booklist.controller.model.pseudonym.PseudonymResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
public class AuthorRequest {

    Long id;
    String name;
    String country;
    Integer birthYear;
    Integer deathYear;
    String image;
    List<PseudonymRequest> pseudonyms;

}
