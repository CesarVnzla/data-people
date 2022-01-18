package com.people.datapeople.exception;

public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = 6705797674945659259L;
    private final Integer code;

    public BusinessException(Integer code, String message) {
        super(message);
        this.code=code;
    }

    public BusinessException(Integer code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
