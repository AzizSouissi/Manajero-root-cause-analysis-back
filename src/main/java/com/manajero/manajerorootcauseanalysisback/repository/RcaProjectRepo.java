package com.manajero.manajerorootcauseanalysisback.repository;

import com.manajero.manajerorootcauseanalysisback.model.RcaProject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RcaProjectRepo extends MongoRepository<RcaProject, String> {
}
