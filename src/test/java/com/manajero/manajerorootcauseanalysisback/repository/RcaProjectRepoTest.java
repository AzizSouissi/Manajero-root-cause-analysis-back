package com.manajero.manajerorootcauseanalysisback.repository;

import com.manajero.manajerorootcauseanalysisback.model.RcaProject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
public class RcaProjectRepoTest {

    @Autowired
    private RcaProjectRepo rcaProjectRepo;

    @Test
    public void testSaveAndFindById() {
        RcaProject project = new RcaProject();
        project.setId("1");
        project.setName("Project Alpha");
        project.setStartDate(LocalDate.of(2024, 8, 1));
        project.setEndDate(LocalDate.of(2024, 12, 31));
        rcaProjectRepo.save(project);

        Optional<RcaProject> foundProject = rcaProjectRepo.findById("1");
        assertThat(foundProject).isPresent();
        assertThat(foundProject.get().getName()).isEqualTo("Project Alpha");
    }

    @Test
    public void testDeleteById() {
        RcaProject project = new RcaProject();
        project.setId("1");
        project.setName("Project Alpha");
        rcaProjectRepo.save(project);

        rcaProjectRepo.deleteById("1");
        Optional<RcaProject> foundProject = rcaProjectRepo.findById("1");
        assertThat(foundProject).isNotPresent();
    }
}
