package com.people.datapeople.exception.controller;

import com.people.datapeople.exception.BusinessException;
import com.people.datapeople.exception.ConnectionException;
import com.people.datapeople.exception.ExceptionValidation;
import com.people.datapeople.model.dto.ExceptionDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import static com.people.datapeople.utility.Constants.*;

@ControllerAdvice
public class ControllerException {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ExceptionDTO> exceptionValidation(final BusinessException exception, final WebRequest request) {

        return new ResponseEntity<>(ExceptionDTO.builder().code(exception.getCode())
                .message(String.format(exception.getMessage())).build(), HttpStatus.OK);

    }

    @ExceptionHandler(ExceptionValidation.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionDTO> exceptionValidation(final ExceptionValidation exception, final WebRequest request) {

        return new ResponseEntity<>(ExceptionDTO.builder().code(400)
                .message(String.format(exception.getMessage())).build(), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ConnectionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionDTO> exceptionValidation(final ConnectionException exception, final WebRequest request) {

        String detailMessage = StringUtils.substringBefore(exception.getCause().getMessage(), SEPARATOR);
        return new ResponseEntity<>(ExceptionDTO.builder().code(exception.getCode())
                .message(String.format(exception.getMessage())).details(detailMessage).build(), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ExceptionDTO> handlerException(final Exception exception, final WebRequest request) {
        return new ResponseEntity<>(ExceptionDTO.builder().code(E_GENERAL_EXCEPTION_CODE)
                .message(String.format(E_GENERAL_EXCEPTION, exception.getLocalizedMessage())).build(), HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
