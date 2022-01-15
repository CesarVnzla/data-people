package com.people.datapeople.controller;


import com.people.datapeople.exception.ExceptionValidation;
import com.people.datapeople.model.dto.PeopleDTO;
import com.people.datapeople.service.PeopleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.people.datapeople.utility.Constants.*;
import static com.people.datapeople.validation.Validation.*;

@Controller
@RequestMapping(REQUEST_MAPPING_PATH)
public class PeopleDataController {


    @Autowired
    private PeopleService peopleService;

    @Operation(summary = OPERATION_GET_PEOPLE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = CODE_RESPONSE_OK, description = MESSAGE_RESPONSE_OK, content = {@Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = PeopleDTO.class))}),
            @ApiResponse(responseCode = CODE_RESPONSE_BAD_REQUEST, description = MESSAGE_RESPONSE_BAD_REQUEST),
            @ApiResponse(responseCode = CODE_RESPONSE_NOT_FOUND, description = MESSAGE_RESPONSE_NOT_FOUND)})
    @GetMapping(PATH_GET_PEOPLE)
    public ResponseEntity<List<PeopleDTO>> getPeople() {

        List<PeopleDTO> result = peopleService.findAll();

        return ResponseEntity.status(HttpStatus.OK)
                .body(result);
    }

    @Operation(summary = OPERATION_GET_PEOPLE_BY_ID)
    @ApiResponses(value = {
            @ApiResponse(responseCode = CODE_RESPONSE_OK, description = MESSAGE_RESPONSE_OK, content = {@Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = PeopleDTO.class))}),
            @ApiResponse(responseCode = CODE_RESPONSE_BAD_REQUEST, description = MESSAGE_RESPONSE_BAD_REQUEST),
            @ApiResponse(responseCode = CODE_RESPONSE_NOT_FOUND, description = MESSAGE_RESPONSE_NOT_FOUND)})
    @GetMapping(PATH_GET_UPDATE_DELETE_PEOPLE_BY_ID)
    public ResponseEntity<PeopleDTO> getPeoplebyId(@PathVariable Long id){
        PeopleDTO result = peopleService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(result);
    }

    @Operation(summary = OPERATION_CREATE_PEOPLE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = CODE_RESPONSE_OK_NO_CONTENT, description = MESSAGE_RESPONSE_OK_NO_CONTENT),
            @ApiResponse(responseCode = CODE_RESPONSE_BAD_REQUEST, description = MESSAGE_RESPONSE_BAD_REQUEST),
            @ApiResponse(responseCode = CODE_RESPONSE_NOT_FOUND, description = MESSAGE_RESPONSE_NOT_FOUND)})
    @PostMapping(PATH_CREATE_PEOPLE)
    public ResponseEntity<Void> createPeople(@Valid @RequestBody PeopleDTO people, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            String message = validateCreate(bindingResult);
            throw new ExceptionValidation(message);
        }
        peopleService.save(people);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = OPERATION_UPDATE_PEOPLE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = CODE_RESPONSE_OK_NO_CONTENT, description = MESSAGE_RESPONSE_OK_NO_CONTENT),
            @ApiResponse(responseCode = CODE_RESPONSE_BAD_REQUEST, description = MESSAGE_RESPONSE_BAD_REQUEST),
            @ApiResponse(responseCode = CODE_RESPONSE_NOT_FOUND, description = MESSAGE_RESPONSE_NOT_FOUND)})
    @PatchMapping(PATH_GET_UPDATE_DELETE_PEOPLE_BY_ID)
    public ResponseEntity<Void> updatePeople(@Valid @RequestBody PeopleDTO people,@PathVariable Long id, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            String message = validateCreate(bindingResult);
            throw new ExceptionValidation(message);
        }
        peopleService.update(people, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = OPERATION_DELETE_PEOPLE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = CODE_RESPONSE_OK_NO_CONTENT, description = MESSAGE_RESPONSE_OK_NO_CONTENT),
            @ApiResponse(responseCode = CODE_RESPONSE_BAD_REQUEST, description = MESSAGE_RESPONSE_BAD_REQUEST),
            @ApiResponse(responseCode = CODE_RESPONSE_NOT_FOUND, description = MESSAGE_RESPONSE_NOT_FOUND)})
    @DeleteMapping(PATH_GET_UPDATE_DELETE_PEOPLE_BY_ID)
    public ResponseEntity<Void> deletePeople(@PathVariable Long id){
        peopleService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
