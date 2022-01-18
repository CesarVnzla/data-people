package com.people.datapeople.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.people.datapeople.dao.PeopleDAO;
import com.people.datapeople.exception.BusinessException;
import com.people.datapeople.exception.ConnectionException;
import com.people.datapeople.model.dto.PeopleDTO;
import com.people.datapeople.model.entity.People;
import com.people.datapeople.service.PeopleService;
import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.people.datapeople.utility.Constants.*;

@Service
public class PeopleServiceImpl implements PeopleService {


    @Autowired
    private PeopleDAO peopleDAO;

    private ObjectMapper mapper = new ObjectMapper();

    /**
     * Metodo que retorna una lista de personas
     * @return List<PeopleDTO>
     */
    @Override
    public List<PeopleDTO> findAll() {
        List<People> listPeople = null;
        try {
            listPeople = peopleDAO.findAll();
        } catch (Exception e) {
            throw new ConnectionException(CODE_CONNECTION_EXCEPTION, MESSAGE_GETLIST_EXCEPTION, e);
        }
        List<PeopleDTO> result = mapper.convertValue(listPeople, new TypeReference<List<PeopleDTO>>() {
        });
        return result;
    }

    /**
     * Busca una persona por el id
     * @param id
     * @return PeopleDTO.class
     */
    @Override
    public PeopleDTO findById(Long id) {
        Optional<People> people = peopleDAO.findById(id);
        if (!people.isPresent()) {
            throw new BusinessException(CODE_BUSINIESS_EXCEPTION, MESSAGE_FINDBYID_EXCEPTION.concat(String.valueOf(id)));
        }
        PeopleDTO rspt = mapper.convertValue(people.get(), PeopleDTO.class);
        return rspt;
    }

    /**
     * Metodo que registra una persona
     * @param peopleDTO
     */
    @Transactional
    @Override
    public void save(PeopleDTO peopleDTO) {
        People people = mapper.convertValue(peopleDTO, People.class);
        try {
            peopleDAO.save(people);
        } catch (Exception e) {
            throw new ConnectionException(CODE_CONNECTION_EXCEPTION, MESSAGE_SAVE_EXCEPTION.concat(String.valueOf(people.getId())), e);
        }
    }

    /**
     * Metodo que actualiza los datos de una persona
     * @param peopleDTO
     * @param id
     */
    @Transactional
    @Override
    public void update(PeopleDTO peopleDTO, Long id) {
        People people = mapper.convertValue(peopleDTO, People.class);
        people.setId(id);
        try {
            peopleDAO.save(people);
        } catch (Exception e) {
            throw new ConnectionException(CODE_CONNECTION_EXCEPTION, MESSAGE_UPDATE_EXCEPTION.concat(String.valueOf(id)), e);
        }
    }

    /**
     * Metodo que elimina una persona por el id
     * @param id
     */
    @Transactional
    @Override
    public void delete(Long id) {
        try {
            peopleDAO.deleteById(id);
        } catch (Exception e) {
            throw new ConnectionException(CODE_CONNECTION_EXCEPTION, MESSAGE_DELETE_EXCEPTION.concat(String.valueOf(id)), e);
        }
    }
}
