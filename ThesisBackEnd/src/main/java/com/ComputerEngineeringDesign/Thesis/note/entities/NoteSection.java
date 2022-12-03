package com.ComputerEngineeringDesign.Thesis.note.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "note_sections")
public class NoteSection {
    @Id
    @SequenceGenerator(name= "NoteSection", sequenceName = "NOTE_SECTION_ID_SEQ")
    @GeneratedValue(generator  = "NoteSection", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String noteSectionName;

    @OneToMany(mappedBy = "noteSection", cascade = CascadeType.ALL)
    private List<Mission> missions;

}
