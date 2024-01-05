package com.llacerximo.booklist.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SagaEntity {

    Long id;
    String name;
    Integer publishStart;
    Integer publishEnd;

}
