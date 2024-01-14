package com.llacerximo.booklist.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum GenreEnum {
    FANTASY(1L, "FANTASÍA"),
    SCI_FI(2L, "SCI_FI"),
    GRIM_DARK(3L, "FANTASÍA OSCURA"),
    ROMANCE(4L, "ROMANCE"),
    MYSTERY(5L, "MISTERIO"),
    EPIC(6L, "ÉPICA"),
    NON_FICTION(7L, "NO FICCIÓN"),
    URBAN_FANTASY(8L, "FANTASÍA URBANA");

    Long id;
    String name;

    public static Map<Long, GenreEnum> toMap() {
        Map<Long, GenreEnum> mapValues = Arrays.stream(GenreEnum.values())
                .collect(Collectors.toMap(value ->value.id, value -> value));
        return mapValues;
    }

}
