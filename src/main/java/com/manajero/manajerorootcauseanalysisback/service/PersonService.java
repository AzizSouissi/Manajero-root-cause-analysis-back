package com.manajero.manajerorootcauseanalysisback.service;

import com.manajero.manajerorootcauseanalysisback.model.Person;

import java.util.List;

public interface PersonService {

    List<?> findAll();

    Person findById(String id);

    Person save(Person p);

    Person update(String id, Person p);

    void delete(String id);
}
