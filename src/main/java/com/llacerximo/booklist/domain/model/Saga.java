package com.llacerximo.booklist.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Saga {

    Long id;
    String name;
    Integer publishStart;
    Integer publishEnd;

}
