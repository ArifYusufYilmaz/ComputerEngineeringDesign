package com.ComputerEngineeringDesign.Thesis.film.dtos;

import com.ComputerEngineeringDesign.Thesis.film.entities.MovieAnalysis;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

@Data
public class MovieResponseDto {
    private Long id;
    private String movieName;
    private boolean haveBeenWatched;
    private Long movieAnalysisId;
}
