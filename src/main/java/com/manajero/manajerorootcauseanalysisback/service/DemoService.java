package com.manajero.manajerorootcauseanalysisback.service;

import com.manajero.manajerorootcauseanalysisback.model.Demo;
import com.manajero.manajerorootcauseanalysisback.model.Person;

import java.util.List;

public interface DemoService {

    Demo find();

    Demo update(Demo demo);

    Demo save(Demo demo);
}
