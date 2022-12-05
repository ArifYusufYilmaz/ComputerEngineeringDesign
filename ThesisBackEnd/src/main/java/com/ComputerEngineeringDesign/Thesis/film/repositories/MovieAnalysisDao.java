package com.ComputerEngineeringDesign.Thesis.film.repositories;

import com.ComputerEngineeringDesign.Thesis.film.entities.MovieAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieAnalysisDao extends JpaRepository<MovieAnalysis, Long> {
}
