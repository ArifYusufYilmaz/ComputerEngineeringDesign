package com.ComputerEngineeringDesign.Thesis.note.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "missions")
public class Mission {
    @Id
    @SequenceGenerator(name = "Mission", sequenceName = "MISSION_ID_SEQ")
    @GeneratedValue(generator = "Mission", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String missionName;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<Task> task;

    @ManyToOne
    private NoteSection noteSection;


}
