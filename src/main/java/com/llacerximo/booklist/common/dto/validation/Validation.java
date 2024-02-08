package com.llacerximo.booklist.common.dto.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

import java.util.Set;

import static jakarta.validation.Validation.buildDefaultValidatorFactory;

public class Validation {

    private static final Validator validator = buildDefaultValidatorFactory().getValidator();

    public static <T> void validate(T subject) {
        Set<ConstraintViolation<T>> violations = validator.validate(subject);
        if (!violations.isEmpty()) throw new ConstraintViolationException(violations);
    }

}
