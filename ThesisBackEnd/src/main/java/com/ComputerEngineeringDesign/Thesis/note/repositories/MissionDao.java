package com.ComputerEngineeringDesign.Thesis.note.repositories;

import com.ComputerEngineeringDesign.Thesis.note.entities.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MissionDao extends JpaRepository<Mission, Long> {
    Optional<List<Mission>> findAllByNoteSection_Id(Long noteSectionId);
}
