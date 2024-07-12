package com.manajero.manajerorootcauseanalysisback.controller;

import com.manajero.manajerorootcauseanalysisback.model.Person;
import com.manajero.manajerorootcauseanalysisback.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        List<?> list = personService.findAll();
        return ResponseEntity.ok().body(list);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        Person p = personService.findById(id);
        return ResponseEntity.ok().body(p);
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody Person p) {
        Person savedPerson = personService.save(p);
        return ResponseEntity.ok().body(savedPerson);
    }


    @PutMapping
    public ResponseEntity<?> update(@RequestBody Person p) {
        Person updatedPerson = personService.update(p);
        return ResponseEntity.ok().body(updatedPerson);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        personService.delete(id);
        return ResponseEntity.ok().body("Deleted successfully...!");
    }
}

