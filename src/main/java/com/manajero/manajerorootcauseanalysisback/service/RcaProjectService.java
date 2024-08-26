package com.manajero.manajerorootcauseanalysisback.service;

import com.manajero.manajerorootcauseanalysisback.model.RcaProject;

import java.util.List;

public interface RcaProjectService {

    List<?> findAll();

    RcaProject findById(String id);

    RcaProject save(RcaProject p);

    RcaProject update(String id, RcaProject p);

    void delete(String id);
}