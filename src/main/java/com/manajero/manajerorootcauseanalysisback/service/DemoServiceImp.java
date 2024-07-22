package com.manajero.manajerorootcauseanalysisback.service;

import com.manajero.manajerorootcauseanalysisback.model.Demo;
import com.manajero.manajerorootcauseanalysisback.repository.DemoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DemoServiceImp implements DemoService {

    @Autowired
    private DemoRepo demoRepository;

    @Override
    public Demo find() {
        return demoRepository.findAll().getFirst();
    }

    public Demo update(String id, Demo demo) {
        Optional<Demo> existingDemoOptional = demoRepository.findById(id);
        if (existingDemoOptional.isPresent()) {
            Demo existingDemo = existingDemoOptional.get();

            if (demo.getIntroduction() != null) existingDemo.setIntroduction(demo.getIntroduction());
            if (demo.getStep1title() != null) existingDemo.setStep1title(demo.getStep1title());
            if (demo.getStep1content() != null) existingDemo.setStep1content(demo.getStep1content());
            if (demo.getStep2title() != null) existingDemo.setStep2title(demo.getStep2title());
            if (demo.getStep2content() != null) existingDemo.setStep2content(demo.getStep2content());
            if (demo.getStep3title() != null) existingDemo.setStep3title(demo.getStep3title());
            if (demo.getStep3content() != null) existingDemo.setStep3content(demo.getStep3content());
            if (demo.getStep4title() != null) existingDemo.setStep4title(demo.getStep4title());
            if (demo.getStep4content() != null) existingDemo.setStep4content(demo.getStep4content());
            if (demo.getExample() != null) existingDemo.setExample(demo.getExample());
            if (demo.getWhy() != null) existingDemo.setWhy(demo.getWhy());
            if (demo.getWhat() != null) existingDemo.setWhat(demo.getWhat());
            if (demo.getHow() != null) existingDemo.setHow(demo.getHow());
            if (demo.getWhatif() != null) existingDemo.setWhatif(demo.getWhatif());

            return demoRepository.save(existingDemo);
        } else {
            // Handle the case where the demo does not exist
            throw new RuntimeException("Demo not found with id: " + id);
        }
    }

    @Override
    public Demo save(Demo demo) {
        return demoRepository.save(demo);
    }

}

