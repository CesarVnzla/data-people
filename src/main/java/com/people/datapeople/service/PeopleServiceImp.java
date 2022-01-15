package com.people.datapeople.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.people.datapeople.dao.PeopleDAO;
import com.people.datapeople.model.dto.PeopleDTO;
import com.people.datapeople.model.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleServiceImp implements PeopleService{


    @Autowired
    private PeopleDAO peopleDAO;


    private ObjectMapper mapper = new ObjectMapper();

    /**
     *
     * @return
     */
    @Override
    public List<PeopleDTO> findAll() {

        List<People> listPeople = peopleDAO.findAll();

        List<PeopleDTO> result = mapper.convertValue(listPeople , new TypeReference<List<PeopleDTO>>() { });

        return result;
    }

    @Override
    public PeopleDTO findById(Long id) {
        Optional<People> people = null;
        people = Optional.ofNullable(peopleDAO.findById(id).orElse(null));
        if (people == null){

        }
        PeopleDTO rspt = mapper.convertValue(people.get(), PeopleDTO.class);
        return rspt;
    }

    @Override
    public void save(PeopleDTO peopleDTO) {
        People people = mapper.convertValue(peopleDTO, People.class);
        peopleDAO.save(people);
    }

    @Override
    public void update(PeopleDTO peopleDTO, Long id) {
        People people = mapper.convertValue(peopleDTO, People.class);
        people.setId(id);
        peopleDAO.save(people);
    }

    @Override
    public void delete(Long id) {
        peopleDAO.deleteById(id);
    }
}
