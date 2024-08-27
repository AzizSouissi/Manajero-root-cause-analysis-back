package com.manajero.manajerorootcauseanalysisback.controller;

import com.manajero.manajerorootcauseanalysisback.model.RcaProject;
import com.manajero.manajerorootcauseanalysisback.service.RcaProjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class RcaProjectControllerTest {

    private MockMvc mockMvc;

    @Mock
    private RcaProjectService rcaProjectService;

    @InjectMocks
    private RcaProjectController rcaProjectController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(rcaProjectController).build();
    }

    @Test
    void testFindAll() throws Exception {
        RcaProject project1 = RcaProject.builder()
                .id("1")
                .name("Project 1")
                .build();

        RcaProject project2 = RcaProject.builder()
                .id("2")
                .name("Project 2")
                .build();

        List<RcaProject> projects = Arrays.asList(project1, project2);

        when(rcaProjectService.findAll()).thenReturn((List) projects);

        mockMvc.perform(get("/rca-project"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name").value("Project 1"))
                .andExpect(jsonPath("$[1].name").value("Project 2"));

        verify(rcaProjectService, times(1)).findAll();
    }

    @Test
    void testFindById() throws Exception {
        RcaProject project = RcaProject.builder()
                .id("1")
                .name("Project 1")
                .description("Test description")
                .build();

        when(rcaProjectService.findById("1")).thenReturn(project);

        mockMvc.perform(get("/rca-project/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Project 1"))
                .andExpect(jsonPath("$.description").value("Test description"));

        verify(rcaProjectService, times(1)).findById("1");
    }

    @Test
    void testSave() throws Exception {
        RcaProject project = RcaProject.builder()
                .name("New Project")
                .description("New description")
                .startDate(LocalDate.of(2024, 8, 26))
                .build();

        RcaProject savedProject = RcaProject.builder()
                .id("1")
                .name("New Project")
                .description("New description")
                .startDate(LocalDate.of(2024, 8, 26))
                .build();

        when(rcaProjectService.save(any(RcaProject.class))).thenReturn(savedProject);

        mockMvc.perform(post("/rca-project")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"New Project\", \"description\": \"New description\", \"startDate\": \"2024-08-26\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("New Project"))
                .andExpect(jsonPath("$.description").value("New description"));

        verify(rcaProjectService, times(1)).save(any(RcaProject.class));
    }

    @Test
    void testUpdate() throws Exception {
        RcaProject updatedProject = RcaProject.builder()
                .id("1")
                .name("Updated Project")
                .build();

        when(rcaProjectService.update(eq("1"), any(RcaProject.class))).thenReturn(updatedProject);

        mockMvc.perform(put("/rca-project/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Updated Project\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Project"));

        verify(rcaProjectService, times(1)).update(eq("1"), any(RcaProject.class));
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(rcaProjectService).delete("1");

        mockMvc.perform(delete("/rca-project/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Deleted successfully...!"));

        verify(rcaProjectService, times(1)).delete("1");
    }
}
