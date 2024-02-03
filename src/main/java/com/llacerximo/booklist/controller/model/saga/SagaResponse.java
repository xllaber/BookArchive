package com.llacerximo.booklist.controller.model.saga;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SagaResponse {

    Long id;
    String name;
    Integer publishStart;
    Integer publishEnd;

}
