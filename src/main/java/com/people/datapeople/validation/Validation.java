package com.people.datapeople.validation;

import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static com.people.datapeople.utility.Constants.CAMPO_EXCEPTION;

public class Validation {


    public static String validateCreate(BindingResult result) {
        Map<String, Object> errors = new HashMap<>();
        AtomicReference<String> mesaje = new AtomicReference<>();
        result.getFieldErrors().forEach(error -> {
            mesaje.set(String.format(CAMPO_EXCEPTION, error.getField().concat(error.getDefaultMessage())));
        });
        return mesaje.get();
    }
}
