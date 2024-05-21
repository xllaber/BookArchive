package com.llacerximo.booklist.common.exception;

public class FileException extends RuntimeException{

    private static final String DESCRIPTION = "File Exception";

    public FileException(String message) {
        super(DESCRIPTION + ". " + message);
    }

}
