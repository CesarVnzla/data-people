package com.people.datapeople.validation;

import com.people.datapeople.validation.impl.Validation;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static com.people.datapeople.utility.Constants.CAMPO_EXCEPTION;

@Component
public class ValidationImp implements Validation {


    @Override
    public String validateCreate(BindingResult result) {
        Map<String, Object> errors = new HashMap<>();
        AtomicReference<String> mesaje = new AtomicReference<>();
        result.getFieldErrors().forEach(error -> {
            mesaje.set(String.format(CAMPO_EXCEPTION, error.getField().concat(error.getDefaultMessage())));
        });
        return mesaje.get();
    }
}
