package com.ComputerEngineeringDesign.Thesis.note.repositories;

import com.ComputerEngineeringDesign.Thesis.note.entities.NoteSection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteSectionDao extends JpaRepository<NoteSection, Long> {
}
