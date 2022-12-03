package com.ComputerEngineeringDesign.Thesis.note.dtos.taskDtos;

import com.ComputerEngineeringDesign.Thesis.note.entities.Mission;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
public class TaskSaveRequestDto {
    private String taskName;
    private Long missionId;
}
