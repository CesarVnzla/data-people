package com.people.datapeople.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ExceptionDTO {

    private Integer code;
    private String message;
}
