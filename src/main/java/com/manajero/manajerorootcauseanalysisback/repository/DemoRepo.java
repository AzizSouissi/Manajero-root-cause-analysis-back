package com.manajero.manajerorootcauseanalysisback.repository;

import com.manajero.manajerorootcauseanalysisback.model.Demo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DemoRepo extends MongoRepository<Demo, String> {
}
