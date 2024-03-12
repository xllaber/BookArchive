package com.llacerximo.booklist.common.dto.validation.annotation;

import com.llacerximo.booklist.common.dto.validation.RereadImpressionsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RereadImpressionsValidator.class)
public @interface ValidImpressions {

    String message() default "Las impresiones no pueden tener menos de 5 caracteres";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
