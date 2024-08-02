package com.manajero.manajerorootcauseanalysisback.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manajero.manajerorootcauseanalysisback.model.Demo;
import com.manajero.manajerorootcauseanalysisback.service.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DemoController.class)
public class DemoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DemoService demoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testFind() throws Exception {
        Demo demo = new Demo();
        demo.setId("1");
        when(demoService.find()).thenReturn(demo);

        mockMvc.perform(get("/demo"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"));

        verify(demoService, times(1)).find();
    }

    @Test
    public void testSave() throws Exception {
        Demo demo = new Demo();
        demo.setId("1");
        when(demoService.save(any(Demo.class))).thenReturn(demo);

        mockMvc.perform(post("/demo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(demo)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"));

        verify(demoService, times(1)).save(any(Demo.class));
    }

    @Test
    public void testUpdate() throws Exception {
        String id = "1";
        Demo demo = new Demo();
        demo.setId("1");
        when(demoService.update(eq(id), any(Demo.class))).thenReturn(demo);

        mockMvc.perform(put("/demo/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(demo)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"));

        verify(demoService, times(1)).update(eq(id), any(Demo.class));
    }
}
