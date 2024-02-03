package com.llacerximo.booklist.controller.model.reread;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RereadResponse {

    Long id;
    LocalDate startDate;
    LocalDate finishDate;

}
