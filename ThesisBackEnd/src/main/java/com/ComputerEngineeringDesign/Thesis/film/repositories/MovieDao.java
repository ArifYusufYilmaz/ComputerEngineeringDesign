package com.ComputerEngineeringDesign.Thesis.film.repositories;

import com.ComputerEngineeringDesign.Thesis.film.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDao extends JpaRepository<Movie, Long> {
}
