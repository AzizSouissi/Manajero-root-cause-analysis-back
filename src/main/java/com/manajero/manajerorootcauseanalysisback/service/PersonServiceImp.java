package com.manajero.manajerorootcauseanalysisback.service;

import com.manajero.manajerorootcauseanalysisback.model.Person;
import com.manajero.manajerorootcauseanalysisback.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Person update(String id, Person person) {
        Optional<Person> existingPersonOptional = repository.findById(id);
        if (existingPersonOptional.isPresent()) {
            Person existingPerson = existingPersonOptional.get();
            if (person.getName() != null) existingPerson.setName(person.getName());
            if (person.getAge() != 0) existingPerson.setAge(person.getAge());
            return repository.save(existingPerson);
        } else {
            throw new RuntimeException("Person not found with id: " + id);
        }
    }

    @Override
    public void delete(String id) {
        repository.findById(id).ifPresent(p -> repository.delete(p));
    }
}

