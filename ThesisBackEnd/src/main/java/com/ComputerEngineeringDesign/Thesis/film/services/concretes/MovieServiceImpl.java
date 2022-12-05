package com.ComputerEngineeringDesign.Thesis.film.services.concretes;

import com.ComputerEngineeringDesign.Thesis.film.dtos.MovieResponseDto;
import com.ComputerEngineeringDesign.Thesis.film.dtos.MovieSaveRequestDto;
import com.ComputerEngineeringDesign.Thesis.film.dtos.MovieUpdateRequestDto;
import com.ComputerEngineeringDesign.Thesis.film.repositories.MovieDao;
import com.ComputerEngineeringDesign.Thesis.film.services.abstracts.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieDao movieDao;

    @Override
    public List<MovieResponseDto> getWatchList() {
        return null;
    }

    @Override
    public List<MovieResponseDto> getWatchedList() {
        return null;
    }

    @Override
    public MovieSaveRequestDto createMovie(MovieSaveRequestDto movieSaveRequestDto) {
        return null;
    }

    @Override
    public MovieUpdateRequestDto updateMovie(Long id, MovieUpdateRequestDto movieUpdateRequestDto) {
        return null;
    }

    @Override
    public void deleteMovieById(Long id) {

    }
}
