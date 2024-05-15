package com.llacerximo.booklist.controller.model.reread;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RereadResponse {

    Long id;
    Integer readTime;
    String impressions;
    LocalDate startDate;
    LocalDate finishDate;

}
