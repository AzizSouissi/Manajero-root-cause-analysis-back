package com.manajero.manajerorootcauseanalysisback.service;

import com.manajero.manajerorootcauseanalysisback.model.Demo;
import com.manajero.manajerorootcauseanalysisback.repository.DemoRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DemoServiceImpTest {

    @Mock
    private DemoRepo demoRepo;

    @InjectMocks
    private DemoServiceImp demoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFind() {
        Demo demo = new Demo();
        when(demoRepo.findAll()).thenReturn(List.of(demo));

        Demo result = demoService.find();

        assertNotNull(result);
        verify(demoRepo, times(1)).findAll();
    }

    @Test
    public void testUpdate() {
        String id = "1";
        Demo demo = new Demo();
        demo.setIntroduction("Updated Introduction");

        Demo existingDemo = new Demo();
        existingDemo.setId(id);

        when(demoRepo.findById(id)).thenReturn(Optional.of(existingDemo));
        when(demoRepo.save(existingDemo)).thenReturn(existingDemo);

        Demo result = demoService.update(id, demo);

        assertNotNull(result);
        assertEquals("Updated Introduction", result.getIntroduction());
        verify(demoRepo, times(1)).findById(id);
        verify(demoRepo, times(1)).save(existingDemo);
    }

    @Test
    public void testSave() {
        Demo demo = new Demo();
        when(demoRepo.save(demo)).thenReturn(demo);

        Demo result = demoService.save(demo);

        assertNotNull(result);
        verify(demoRepo, times(1)).save(demo);
    }
}



