package com.manajero.manajerorootcauseanalysisback.controller;

import com.manajero.manajerorootcauseanalysisback.model.RcaProject;
import com.manajero.manajerorootcauseanalysisback.service.RcaProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rca-project")
@CrossOrigin("*")
public class RcaProjectController {

    @Autowired
    private RcaProjectService rcaProjectService;

    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        List<?> list = rcaProjectService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RcaProject> findById(@PathVariable String id) {
        RcaProject project = rcaProjectService.findById(id);
        return ResponseEntity.ok().body(project);
    }

    @PostMapping
    public ResponseEntity<RcaProject> save(@RequestBody RcaProject project) {
        RcaProject savedProject = rcaProjectService.save(project);
        return ResponseEntity.ok().body(savedProject);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RcaProject> update(@PathVariable String id, @RequestBody RcaProject project) {
        RcaProject updatedProject = rcaProjectService.update(id, project);
        return ResponseEntity.ok().body(updatedProject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        rcaProjectService.delete(id);
        return ResponseEntity.ok().body("Deleted successfully...!");
    }
}
