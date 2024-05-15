package com.llacerximo.booklist.domain.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reread {

    private Long id;
    private Long bookId;
    private Integer readTime;
    private String impressions;
    private LocalDate startDate;
    private LocalDate finishDate;

}
