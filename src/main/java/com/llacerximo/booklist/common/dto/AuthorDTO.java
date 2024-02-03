package com.llacerximo.booklist.common.dto;

import com.llacerximo.booklist.common.exception.DtoValidationException;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AuthorDTO {

    Long id;
    String name;
    String country;
    Integer birthYear;
    Integer deathYear;
    String image;

    public void setBirthYear(Integer birthYear) {
        if (this.deathYear != null && birthYear != null && this.deathYear <= birthYear) {
            throw new DtoValidationException("La fecha de nacimiento no puede ser mayor que la de muerte");
        }
        this.birthYear = birthYear;
    }

    public void setDeathYear(Integer deathYear) {
        if (this.birthYear != null && deathYear != null && deathYear <= this.birthYear){
            throw new DtoValidationException("La fecha de muerte no puede ser menor que la de nacimiento");
        }
        this.deathYear = deathYear;
    }

}
