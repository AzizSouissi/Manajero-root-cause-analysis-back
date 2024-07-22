package com.manajero.manajerorootcauseanalysisback.controller;

import com.manajero.manajerorootcauseanalysisback.model.Demo;
import com.manajero.manajerorootcauseanalysisback.model.Person;
import com.manajero.manajerorootcauseanalysisback.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo")
@CrossOrigin("*")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping
    public ResponseEntity<?> find() {
        Demo demo = demoService.find();
        return ResponseEntity.ok().body(demo);
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody Demo demo) {
        Demo savedDemo = demoService.save(demo);
        return ResponseEntity.ok().body(savedDemo);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Demo> update(@PathVariable String id, @RequestBody Demo demo) {
        Demo updatedDemo = demoService.update(id, demo);
        return ResponseEntity.ok().body(updatedDemo);
    }
}

