package com.manajero.manajerorootcauseanalysisback.repository;

import com.manajero.manajerorootcauseanalysisback.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepo extends MongoRepository<Person, String> {
}
