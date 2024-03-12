package com.llacerximo.booklist.domain.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Saga {

    Long id;
    String name;
    Integer publishStart;
    Integer publishEnd;

}
