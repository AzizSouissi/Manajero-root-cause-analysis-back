package com.manajero.manajerorootcauseanalysisback.service;

import com.manajero.manajerorootcauseanalysisback.model.Person;
import com.manajero.manajerorootcauseanalysisback.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImp implements PersonService {

    @Autowired
    private PersonRepo repository;

    @Override
    public List<Person> findAll() {
        return repository.findAll();
    }

    @Override
    public Person findById(String id) {
        return repository.findById(id).orElse(new Person());
    }

    @Override
    public Person save(Person p) {
        return repository.save(p);
    }

    @Override
    public Person update(Person p) {
        return repository.save(p);
    }

    @Override
    public void delete(String id) {
        repository.findById(id).ifPresent(p -> repository.delete(p));
    }
}

