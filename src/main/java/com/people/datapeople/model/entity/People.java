package com.people.datapeople.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="people")
@Setter
@Getter
public class People {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min=4, max=20)
    @Column(nullable = false)
    private String name;

    @NotEmpty
    @Size(min=4, max=20)
    @Column(nullable = false)
    private String lastname;

    @NotNull(message = " el campo no age puede estar vacio")
    private Integer age;

    @NotNull(message = " el campo no document puede estar vacio")
    @Size(min=8, max=11)
    private String document;

    @NotEmpty
    @Email
    @Column(nullable = false, unique = false)
    private String email;

}
