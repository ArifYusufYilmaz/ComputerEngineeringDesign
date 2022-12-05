package com.ComputerEngineeringDesign.Thesis.film.services.abstracts;

import com.ComputerEngineeringDesign.Thesis.film.dtos.MovieResponseDto;
import com.ComputerEngineeringDesign.Thesis.film.dtos.MovieSaveRequestDto;
import com.ComputerEngineeringDesign.Thesis.film.dtos.MovieUpdateRequestDto;

import java.util.List;

public interface MovieService {
    List<MovieResponseDto> getWatchList();

    List<MovieResponseDto> getWatchedList();

    MovieSaveRequestDto createMovie(MovieSaveRequestDto movieSaveRequestDto);

    MovieUpdateRequestDto updateMovie(Long id, MovieUpdateRequestDto movieUpdateRequestDto);

    void deleteMovieById(Long id);
}
