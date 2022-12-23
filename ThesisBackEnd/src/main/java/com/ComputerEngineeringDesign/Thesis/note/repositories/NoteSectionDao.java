package com.ComputerEngineeringDesign.Thesis.note.repositories;

import com.ComputerEngineeringDesign.Thesis.note.entities.NoteSection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoteSectionDao extends JpaRepository<NoteSection, Long> {
    Optional<List<NoteSection>> findAllByUserId(Long userId);
}
