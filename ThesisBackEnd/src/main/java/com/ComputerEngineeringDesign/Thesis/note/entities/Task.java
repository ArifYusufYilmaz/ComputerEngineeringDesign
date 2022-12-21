package com.ComputerEngineeringDesign.Thesis.note.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name ="tasks")
@Data
public class Task {
    @Id
    @SequenceGenerator(name = "Task", sequenceName = "TASK_ID_SEQ")
    @GeneratedValue(generator = "Task", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String taskName;

    @ManyToOne
    private Mission mission;
}
