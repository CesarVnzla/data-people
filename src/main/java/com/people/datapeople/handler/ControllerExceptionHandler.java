package com.people.datapeople.handler;

import com.people.datapeople.exception.ExceptionValidation;
import com.people.datapeople.model.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import static com.people.datapeople.utility.Constants.*;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ExceptionDTO> handlerException(final Exception exception, final WebRequest request) {

        return new ResponseEntity<>(ExceptionDTO.builder().code(E_GENERAL_EXCEPTION_CODE)
                .message(String.format(E_GENERAL_EXCEPTION, exception.getLocalizedMessage())).build(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(ExceptionValidation.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionDTO> exceptionValidation(final Exception exception, final WebRequest request) {

        return new ResponseEntity<>(ExceptionDTO.builder().code(CAMPO_EXCEPTION_CODE)
                .message(String.format(exception.getLocalizedMessage())).build(), HttpStatus.BAD_REQUEST);

    }
}
