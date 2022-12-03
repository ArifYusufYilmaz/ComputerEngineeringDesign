package com.ComputerEngineeringDesign.Thesis.note.dtos.noteSectionDtos;

import com.ComputerEngineeringDesign.Thesis.note.entities.Mission;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class NoteSectionResponseDto {
    private Long id;
    private String noteSectionName;
    //private List<Mission> missions;
}
