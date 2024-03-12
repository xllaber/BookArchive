package com.llacerximo.booklist.common.dto.validation;

import com.llacerximo.booklist.common.dto.validation.annotation.ValidImpressions;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RereadImpressionsValidator implements ConstraintValidator<ValidImpressions, String> {

    @Override
    public void initialize(ValidImpressions constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s.length() < 5) {
            return false;
        }
        return true;
    }

}
