package com.ComputerEngineeringDesign.Thesis.note.dtos.missionDtos;

import com.ComputerEngineeringDesign.Thesis.note.entities.NoteSection;
import com.ComputerEngineeringDesign.Thesis.note.entities.Task;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class MissionSaveRequestDto {

    private String missionName;
    private Long noteSectionId;
}
