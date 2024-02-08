package com.llacerximo.booklist.common.exception;

public class DtoValidationException extends RuntimeException{

    private static final String DESCRIPTION = "DTO Validation Exception";

    public DtoValidationException(String message) {
        super(DESCRIPTION + ". " + message);
    }

}
