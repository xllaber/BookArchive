package com.llacerximo.booklist.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class RereadDTO {

    Long id;
    String impressions;

}
