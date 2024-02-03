package com.llacerximo.booklist.domain.model;

import com.llacerximo.booklist.common.dto.AuthorDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Pseudonym {

    Long id;
    String pseudonym;

}
