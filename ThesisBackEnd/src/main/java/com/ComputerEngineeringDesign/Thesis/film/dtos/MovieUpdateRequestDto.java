package com.ComputerEngineeringDesign.Thesis.film.dtos;

import lombok.Data;

@Data
public class MovieUpdateRequestDto {
    private Long id;
    private boolean haveBeenWatched;
}
