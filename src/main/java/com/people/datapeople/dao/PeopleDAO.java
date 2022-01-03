package com.people.datapeople.dao;

import com.people.datapeople.model.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleDAO extends JpaRepository<People, Long> {
}
