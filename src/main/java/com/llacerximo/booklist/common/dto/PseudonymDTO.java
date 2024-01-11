package com.llacerximo.booklist.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class PseudonymDTO {

    Long id;
    String pseudonym;
    List<AuthorDTO> authors;

}
