package com.llacerximo.booklist.controller.model.reread;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class RereadCreateRequest {

    String impressions;
    LocalDate startDate;
    LocalDate finishDate;

}
