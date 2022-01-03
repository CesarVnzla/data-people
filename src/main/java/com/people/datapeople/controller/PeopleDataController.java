package com.people.datapeople.controller;


import com.people.datapeople.exception.ExceptionValidation;
import com.people.datapeople.model.dto.PeopleDTO;
import com.people.datapeople.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.people.datapeople.validation.Validation.*;

@Controller
@RequestMapping("/api")
public class PeopleDataController {


    @Autowired
    private PeopleService peopleService;

    @GetMapping("/people")
    public ResponseEntity<List<PeopleDTO>> getPeople() {

        List<PeopleDTO> result = peopleService.findAll();

        return ResponseEntity.status(HttpStatus.OK)
                .body(result);
    }


    @GetMapping("/people/{id}")
    public ResponseEntity<PeopleDTO> getPeoplebyId(@PathVariable Long id){
        PeopleDTO result = peopleService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(result);
    }

    @PostMapping("/people")
    public ResponseEntity<?> createPeople(@Valid @RequestBody PeopleDTO people, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            String message = validateCreate(bindingResult);
            throw new ExceptionValidation(message);
        }
        peopleService.save(people);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("/people/update")
    public ResponseEntity<?> updatePeople(@Valid @RequestBody PeopleDTO people, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            String message = validateCreate(bindingResult);
            throw new ExceptionValidation(message);
        }
        peopleService.update(people);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/people/delete/{id}")
    public ResponseEntity<?> deletePeople(@PathVariable Long id){
        peopleService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
