package com.manajero.manajerorootcauseanalysisback.service;

import com.manajero.manajerorootcauseanalysisback.model.RcaProject;
import com.manajero.manajerorootcauseanalysisback.repository.RcaProjectRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RcaProjectServiceImpTest {

    @Mock
    private RcaProjectRepo rcaProjectRepository;

    @InjectMocks
    private RcaProjectServiceImp rcaProjectService;

    private RcaProject rcaProject;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        rcaProject = new RcaProject();
        rcaProject.setId("1");
        rcaProject.setName("Test Project");
    }

    @Test
    void testFindAllProjects() {
        when(rcaProjectRepository.findAll()).thenReturn(List.of(rcaProject));

        List<RcaProject> projects = rcaProjectService.findAll();

        assertNotNull(projects);
        assertEquals(1, projects.size());
        assertEquals("Test Project", projects.get(0).getName());
        verify(rcaProjectRepository, times(1)).findAll();
    }

    @Test
    void testFindProjectById() {
        when(rcaProjectRepository.findById("1")).thenReturn(Optional.of(rcaProject));

        Optional<RcaProject> project = Optional.ofNullable(rcaProjectService.findById("1"));

        assertNotNull(project);
        assertEquals("Test Project", project.get().getName());
        verify(rcaProjectRepository, times(1)).findById("1");
    }

    @Test
    void testSaveProject() {
        when(rcaProjectRepository.save(any(RcaProject.class))).thenReturn(rcaProject);

        RcaProject savedProject = rcaProjectService.save(rcaProject);

        assertNotNull(savedProject);
        assertEquals("Test Project", savedProject.getName());
        verify(rcaProjectRepository, times(1)).save(rcaProject);
    }

    @Test
    void testUpdateProject() {
        when(rcaProjectRepository.save(any(RcaProject.class))).thenReturn(rcaProject);

        RcaProject updatedProject = rcaProjectService.update(rcaProject.getId(), rcaProject);

        assertNotNull(updatedProject);
        assertEquals("Test Project", updatedProject.getName());
        verify(rcaProjectRepository, times(1)).save(rcaProject);
    }

    @Test
    void testDeleteProject() {
        doNothing().when(rcaProjectRepository).deleteById("1");

        rcaProjectService.delete("1");

        verify(rcaProjectRepository, times(1)).deleteById("1");
    }
}
