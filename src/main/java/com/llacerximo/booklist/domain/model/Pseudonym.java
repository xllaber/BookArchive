package com.llacerximo.booklist.domain.model;

import com.llacerximo.booklist.common.dto.AuthorDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Pseudonym {

    Long id;
    String pseudonym;
    List<AuthorDTO> authors;

}
