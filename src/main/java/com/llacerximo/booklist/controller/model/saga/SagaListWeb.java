package com.llacerximo.booklist.controller.model.saga;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SagaListWeb {

    Long id;
    String name;
    Integer publishStart;
    Integer publishEnd;

}
