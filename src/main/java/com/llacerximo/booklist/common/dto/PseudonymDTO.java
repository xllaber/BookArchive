package com.llacerximo.booklist.common.dto;

import com.llacerximo.booklist.domain.model.Author;
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
