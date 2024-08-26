package com.manajero.manajerorootcauseanalysisback.service;

import com.manajero.manajerorootcauseanalysisback.model.RcaProject;
import com.manajero.manajerorootcauseanalysisback.repository.RcaProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RcaProjectServiceImp implements RcaProjectService {

    @Autowired
    private RcaProjectRepo repository;

    @Override
    public List<RcaProject> findAll() {
        return repository.findAll();
    }

    @Override
    public RcaProject findById(String id) {
        return repository.findById(id).orElse(new RcaProject());
    }

    @Override
    public RcaProject save(RcaProject project) {
        return repository.save(project);
    }

    @Override
    public RcaProject update(String id, RcaProject updatedProject) {
        Optional<RcaProject> existingRcaProjectOptional = repository.findById(id);
        if (existingRcaProjectOptional.isPresent()) {
            RcaProject existingRcaProject = existingRcaProjectOptional.get();

            // Update only non-null fields
            if (updatedProject.getName() != null) existingRcaProject.setName(updatedProject.getName());
            if (updatedProject.getDescription() != null) existingRcaProject.setDescription(updatedProject.getDescription());
            if (updatedProject.getStartDate() != null) existingRcaProject.setStartDate(updatedProject.getStartDate());
            if (updatedProject.getEndDate() != null) existingRcaProject.setEndDate(updatedProject.getEndDate());
            if (updatedProject.getStatus() != null) existingRcaProject.setStatus(updatedProject.getStatus());
            if (updatedProject.getOwner() != null) existingRcaProject.setOwner(updatedProject.getOwner());
            if (updatedProject.getRootCause() != null) existingRcaProject.setRootCause(updatedProject.getRootCause());
            if (updatedProject.getCorrectiveAction() != null) existingRcaProject.setCorrectiveAction(updatedProject.getCorrectiveAction());
            if (updatedProject.getCategory() != null) existingRcaProject.setCategory(updatedProject.getCategory());
            if (updatedProject.getTeamMembers() != null) existingRcaProject.setTeamMembers(updatedProject.getTeamMembers());
            if (updatedProject.getPriority() != null) existingRcaProject.setPriority(updatedProject.getPriority());
            if (updatedProject.getImpact() != null) existingRcaProject.setImpact(updatedProject.getImpact());

            return repository.save(existingRcaProject);
        } else {
            throw new RuntimeException("Project not found with id: " + id);
        }
    }

    @Override
    public void delete(String id) {
        repository.findById(id).ifPresent(repository::delete);
    }
}
