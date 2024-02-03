package com.llacerximo.booklist.common.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class RereadDTO {

    Long id;
    String impressions;
    LocalDate startDate;
    LocalDate finishDate;

}
