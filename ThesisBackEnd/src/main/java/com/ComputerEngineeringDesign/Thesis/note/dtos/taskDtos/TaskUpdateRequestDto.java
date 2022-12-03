package com.ComputerEngineeringDesign.Thesis.note.dtos.taskDtos;

import com.ComputerEngineeringDesign.Thesis.note.entities.Mission;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
public class TaskUpdateRequestDto {
    private Long id;
    private String taskName;
    private Long missionId;
}
