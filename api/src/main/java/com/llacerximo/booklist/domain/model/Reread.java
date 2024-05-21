package com.llacerximo.booklist.domain.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reread {

    Long id;
    String impressions;
    LocalDate startDate;
    LocalDate finishDate;

}
