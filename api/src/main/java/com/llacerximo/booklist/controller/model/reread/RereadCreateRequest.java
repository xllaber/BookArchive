package com.llacerximo.booklist.controller.model.reread;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class RereadCreateRequest {

    private Long id;
    private Long bookId;
    private String impressions;
    private LocalDate startDate;
    private LocalDate finishDate;

}
