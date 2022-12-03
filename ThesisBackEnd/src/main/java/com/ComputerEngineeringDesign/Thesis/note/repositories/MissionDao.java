package com.ComputerEngineeringDesign.Thesis.note.repositories;

import com.ComputerEngineeringDesign.Thesis.note.entities.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionDao extends JpaRepository<Mission, Long> {
}
