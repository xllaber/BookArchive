package com.llacerximo.booklist.common.exception;

public class EntityValidationException extends RuntimeException{

    private static final String DESCRIPTION = "Entity Validation Exception";

    public EntityValidationException(String message) {
        super(DESCRIPTION + ". " + message);
    }


}
