package com.llacerximo.booklist.common.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class BookDTO {

    @Nullable
    Long id;
    @Nullable
    String title;
    @Nullable
    @Min(value = 1, message = "Debe tener mas de 0 paginas")
    Integer pages;
    @Nullable
    Integer publishYear;
    @Nullable
    Double sagaNum;
    @Nullable
    Boolean fave;
    @Nullable
    String image;
    @Nullable
    SagaDTO saga;
    @Nullable
    List<AuthorDTO> authors;
    @Nullable
    List<RereadDTO> rereads;
    @Nullable
    List<GenreDTO> genres;

}
