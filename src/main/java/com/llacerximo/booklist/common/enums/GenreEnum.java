package com.llacerximo.booklist.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum GenreEnum {
    FANTASY(1L, "Fantasy"),
    SCI_FI(2L, "Sci-Fi"),
    GRIM_DARK(3L, "Grim Dark"),
    ROMANCE(4L, "Romance"),
    MYSTERY(5L, "Mystery"),
    EPIC(6L, "Epic"),
    NON_FICTION(7L, "Non-fiction"),
    URBAN_FANTASY(8L, "Urban fantasy");

    Long id;
    String name;

    public static Map<Long, GenreEnum> toMap() {
        Map<Long, GenreEnum> mapValues = Arrays.stream(GenreEnum.values())
                .collect(Collectors.toMap(value ->value.id, value -> value));
        return mapValues;
    }

}
