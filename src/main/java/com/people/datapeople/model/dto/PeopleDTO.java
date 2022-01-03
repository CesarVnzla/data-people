package com.people.datapeople.model.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

import static com.people.datapeople.utility.Constants.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class PeopleDTO {

    private Long id;
    @NotBlank(message = MESSAGE)
    @Size(min=4, max=20 , message = VALIDATE_LONGITUD)
    private String name;
    @NotBlank(message = MESSAGE)
    @Size(min=4, max=20 , message = VALIDATE_LONGITUD)
    private String lastname;
    @NotNull(message = MESSAGE)
    private Integer age;
    @NotBlank(message = MESSAGE)
    @Size(min=9, max=11 , message = VALIDATE_LONGITUD_DOCUMENT)
    private String document;
    @NotBlank(message = MESSAGE)
    private String email;

}
