package com.ComputerEngineeringDesign.Thesis.film.dtos;

import lombok.Data;

@Data
public class MovieSaveRequestDto {

    private String movieName;
    private boolean haveBeenWatched;
}
