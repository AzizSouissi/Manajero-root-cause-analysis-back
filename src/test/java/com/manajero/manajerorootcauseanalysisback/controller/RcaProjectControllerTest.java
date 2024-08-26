package com.manajero.manajerorootcauseanalysisback.controller;

import com.manajero.manajerorootcauseanalysisback.model.RcaProject;
import com.manajero.manajerorootcauseanalysisback.service.RcaProjectService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RcaProjectController.class)
public class RcaProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private RcaProjectService rcaProjectService;

    @InjectMocks
    private RcaProjectController rcaProjectController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(rcaProjectController).build();
    }

    @Test
    public void testFindAll() throws Exception {
        RcaProject project = RcaProject.builder()
                .id("1")
                .name("Project Alpha")
                .description("Root Cause Analysis for Project Alpha")
                .startDate(LocalDate.of(2024, 8, 1))
                .endDate(LocalDate.of(2024, 12, 31))
                .status("In Progress")
                .build();

        when(rcaProjectService.findAll());

        mockMvc.perform(get("/rca-project")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].name").value("Project Alpha"))
                .andExpect(jsonPath("$[0].description").value("Root Cause Analysis for Project Alpha"))
                .andExpect(jsonPath("$[0].status").value("In Progress"));
    }

    @Test
    public void testFindById() throws Exception {
        RcaProject project = RcaProject.builder()
                .id("1")
                .name("Project Alpha")
                .description("Root Cause Analysis for Project Alpha")
                .build();

        when(rcaProjectService.findById("1")).thenReturn(project);

        mockMvc.perform(get("/rca-project/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("Project Alpha"))
                .andExpect(jsonPath("$.description").value("Root Cause Analysis for Project Alpha"));
    }

    @Test
    public void testSave() throws Exception {
        RcaProject project = RcaProject.builder()
                .id("1")
                .name("Project Alpha")
                .description("Root Cause Analysis for Project Alpha")
                .build();

        when(rcaProjectService.save(any(RcaProject.class))).thenReturn(project);

        mockMvc.perform(post("/rca-project")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(project)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("Project Alpha"))
                .andExpect(jsonPath("$.description").value("Root Cause Analysis for Project Alpha"));
    }

    @Test
    public void testUpdate() throws Exception {
        RcaProject project = RcaProject.builder()
                .id("1")
                .name("Project Alpha Updated")
                .description("Updated Root Cause Analysis for Project Alpha")
                .build();

        when(rcaProjectService.update(eq("1"), any(RcaProject.class))).thenReturn(project);

        mockMvc.perform(put("/rca-project/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(project)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("Project Alpha Updated"))
                .andExpect(jsonPath("$.description").value("Updated Root Cause Analysis for Project Alpha"));
    }

    @Test
    public void testDelete() throws Exception {
        doNothing().when(rcaProjectService).delete("1");

        mockMvc.perform(delete("/rca-project/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Deleted successfully...!"));

        verify(rcaProjectService, times(1)).delete("1");
    }
}
