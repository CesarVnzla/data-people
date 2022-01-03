package com.people.datapeople.exception;

public class ExceptionValidation extends RuntimeException{

    private static final long serialVersionUID = 6705797674945659259L;

    public ExceptionValidation( String message) {
        super(message);
    }

    public ExceptionValidation(String message, Throwable throwable) {
        super(message, throwable);
    }
}
