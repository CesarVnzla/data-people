package com.people.datapeople.controller;

import com.people.datapeople.model.dto.PeopleDTO;
import com.people.datapeople.service.PeopleService;
import com.people.datapeople.service.impl.PeopleServiceImpl;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class PeopleDataControllerTest {

    PeopleDTO people;
    List<PeopleDTO> peopleDTOList;
    PeopleService peopleService;

    @BeforeEach
    void initMetodoTest(){
        people = new PeopleDTO();
        peopleDTOList = new ArrayList<>();
        people.setId(1L);
        people.setName("Cesar");
        people.setLastname("Reinoso");
        people.setAge(30);
        people.setDocument("95945483");
        people.setEmail("cesar@gmail.com");
        peopleDTOList.add(people);
        peopleService = Mockito.mock(PeopleService.class);

    }

    @AfterEach
    void tearDown() {
        System.out.println("finalizando el metodo de prueba.");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("inicializando el test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("finalizando el test");
    }

    @Test
    void getPeople() {
        List<PeopleDTO> result;
        given(peopleService.findAll()).willReturn(peopleDTOList);
        result = peopleService.findAll();
        assertNotNull(result);
    }

    @Test
    void getPeoplebyId() {
        PeopleDTO result;
        given(peopleService.findById(Mockito.any())).willReturn(people);
        result = peopleService.findById(1L);
        assertNotNull(result);
    }

    @Test
    void createPeople() {
        peopleService.save(people);
    }

    @Test
    void updatePeople() {
        PeopleDTO peopleUpdate = new PeopleDTO();
        peopleUpdate.setEmail("cesar15@gmail.com");
        peopleService.update(peopleUpdate, 1L);
    }

    @Test
    void deletePeople() {
        peopleService.delete(1L);
    }
}