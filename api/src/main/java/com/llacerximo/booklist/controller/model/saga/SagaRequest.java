package com.llacerximo.booklist.controller.model.saga;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class SagaRequest {

    Long id;
    String name;
    Integer publishStart;
    Integer publishEnd;

}
