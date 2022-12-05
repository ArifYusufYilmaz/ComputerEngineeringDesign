package com.ComputerEngineeringDesign.Thesis.film.controllers;

import com.ComputerEngineeringDesign.Thesis.film.dtos.MovieResponseDto;
import com.ComputerEngineeringDesign.Thesis.film.dtos.MovieSaveRequestDto;
import com.ComputerEngineeringDesign.Thesis.film.dtos.MovieUpdateRequestDto;
import com.ComputerEngineeringDesign.Thesis.film.services.abstracts.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
 haveBeenWatched? enum-yes,bool-True  watchedList
 haveBeenWatched? enum-no,bool-False  watchList
 */
@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/watchList")
    public List<MovieResponseDto> getWatchList(){
        return movieService.getWatchList();
    }
    @GetMapping("/watchedList")
    public List<MovieResponseDto> getWatchedList(){
        return movieService.getWatchedList();
    }
    @PostMapping
    public MovieSaveRequestDto createMovie(@RequestBody MovieSaveRequestDto movieSaveRequestDto){
        return movieService.createMovie(movieSaveRequestDto);
    }
    @PutMapping("/{id}")
    public MovieUpdateRequestDto updateMovie(@PathVariable Long id, @RequestBody MovieUpdateRequestDto movieUpdateRequestDto){
        return movieService.updateMovie(id, movieUpdateRequestDto);
    }
    @DeleteMapping("/{id}")
    public void deleteMovieById(@PathVariable Long id){
        movieService.deleteMovieById(id);
    }
}
