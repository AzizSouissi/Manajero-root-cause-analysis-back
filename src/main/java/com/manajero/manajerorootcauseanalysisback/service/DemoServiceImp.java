package com.manajero.manajerorootcauseanalysisback.service;

import com.manajero.manajerorootcauseanalysisback.model.Demo;
import com.manajero.manajerorootcauseanalysisback.model.Person;
import com.manajero.manajerorootcauseanalysisback.repository.DemoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImp implements DemoService {

    @Autowired
    private DemoRepo repository;

    @Override
    public Demo find() {
        return repository.findAll().getFirst();
    }

    @Override
    public Demo update(Demo demo) {
        return repository.save(demo);
    }

    @Override
    public Demo save(Demo demo) {
        return repository.save(demo);
    }

}

