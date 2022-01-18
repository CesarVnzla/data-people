package com.people.datapeople.validation;

import org.springframework.validation.BindingResult;

public interface Validation {

    public String validateCreate(BindingResult result);
}
