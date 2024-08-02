package com.manajero.manajerorootcauseanalysisback.repository;

import com.manajero.manajerorootcauseanalysisback.model.Demo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class DemoRepoTest {

    @Autowired
    private DemoRepo demoRepo;

    @BeforeEach
    public void setUp() {
        // Clear the collection before each test
        demoRepo.deleteAll();
    }

    @AfterEach
    public void tearDown() {
        // Optionally clear the collection after each test
        demoRepo.deleteAll();
    }

    @Test
    public void testSaveAndFindById() {
        Demo demo = new Demo();
        demo.setId("1");
        demo.setIntroduction("Introduction");

        demoRepo.save(demo);

        Optional<Demo> foundDemo = demoRepo.findById("1");

        assertTrue(foundDemo.isPresent());
        assertEquals("Introduction", foundDemo.get().getIntroduction());
    }

    @Test
    public void testFindAll() {
        Demo demo1 = new Demo();
        demo1.setId("1");
        demo1.setIntroduction("Introduction 1");

        Demo demo2 = new Demo();
        demo2.setId("2");
        demo2.setIntroduction("Introduction 2");

        demoRepo.save(demo1);
        demoRepo.save(demo2);

        Iterable<Demo> demos = demoRepo.findAll();

        assertNotNull(demos);
        assertTrue(demos.iterator().hasNext()); // Ensure that there are elements
        assertEquals(2, ((Collection<?>) demos).size()); // Verify the number of elements
    }

    @Test
    public void testDeleteById() {
        Demo demo = new Demo();
        demo.setId("1");
        demo.setIntroduction("Introduction");

        demoRepo.save(demo);

        demoRepo.deleteById("1");

        Optional<Demo> foundDemo = demoRepo.findById("1");
        assertFalse(foundDemo.isPresent());
    }
}
