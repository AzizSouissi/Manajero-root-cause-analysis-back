package com.manajero.manajerorootcauseanalysisback.model;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RcaProject implements Serializable {
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private String owner;
    private String rootCause;
    private String correctiveAction;
    private String category;
    private List<String> teamMembers;
    private String priority;
    private String impact;
}