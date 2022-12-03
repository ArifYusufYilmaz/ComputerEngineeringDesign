package com.ComputerEngineeringDesign.Thesis.note.repositories;

import com.ComputerEngineeringDesign.Thesis.note.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDao extends JpaRepository<Task, Long> {
}
