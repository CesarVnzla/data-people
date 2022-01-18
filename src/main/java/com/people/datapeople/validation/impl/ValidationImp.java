package com.people.datapeople.validation.impl;

import com.people.datapeople.validation.Validation;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static com.people.datapeople.utility.Constants.EXCEPTION_VALIDATION_MESSAGE;

@Component
public class ValidationImp implements Validation {


    @Override
    public String validateCreate(BindingResult result) {
        Map<String, Object> errors = new HashMap<>();
        AtomicReference<String> mesaje = new AtomicReference<>();
        result.getFieldErrors().forEach(error -> {
            mesaje.set(String.format(EXCEPTION_VALIDATION_MESSAGE, error.getField().concat(error.getDefaultMessage())));
        });
        return mesaje.get();
    }
}
