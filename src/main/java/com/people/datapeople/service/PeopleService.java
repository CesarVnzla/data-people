package com.people.datapeople.service;

import com.people.datapeople.model.dto.PeopleDTO;

import java.util.List;

public interface PeopleService {

    public List<PeopleDTO> findAll();

    public PeopleDTO findById(Long id);

    public void save(PeopleDTO people);

    public void update(PeopleDTO people);

    public void delete(Long id);
}
