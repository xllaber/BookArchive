package com.llacerximo.booklist.common.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SagaDTO {

    Long id;
    String name;
    Integer publishStart;
    Integer publishEnd;

}
