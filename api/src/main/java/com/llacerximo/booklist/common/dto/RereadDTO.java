package com.llacerximo.booklist.common.dto;

import com.llacerximo.booklist.common.dto.validation.annotation.ValidImpressions;
import com.llacerximo.booklist.common.exception.DtoValidationException;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class RereadDTO {

    Long id;
    Long bookId;
    Integer readTime;
    @ValidImpressions
    String impressions;
    LocalDate startDate;
    LocalDate finishDate;

    public void setStartDate(LocalDate startDate) {
        if (this.finishDate != null && this.finishDate.isBefore(startDate))
            throw new DtoValidationException("Una lectura no puede acabar antes de empezar");
        this.startDate = startDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        if (this.startDate != null && this.startDate.isAfter(finishDate))
            throw new DtoValidationException("Una lectura no puede empezar despues de acabar");
        this.startDate = startDate;
    }

}
