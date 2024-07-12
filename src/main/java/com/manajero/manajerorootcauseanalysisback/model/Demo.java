package com.manajero.manajerorootcauseanalysisback.model;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Demo implements Serializable {
    @Id
    private String id;
    private String introduction;
    private String step1title;
    private String step1content;
    private String step2title;
    private String step2content;
    private String step3title;
    private String step3content;
    private String step4title;
    private String step4content;
    private String example;
    private String why;
    private String what;
    private String how;
    private String whatif;
}
