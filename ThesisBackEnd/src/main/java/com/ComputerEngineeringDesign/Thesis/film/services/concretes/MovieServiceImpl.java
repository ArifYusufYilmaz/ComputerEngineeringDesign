package com.ComputerEngineeringDesign.Thesis.film.services.concretes;

import com.ComputerEngineeringDesign.Thesis.film.repositories.MovieDao;
import com.ComputerEngineeringDesign.Thesis.film.services.abstracts.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieDao movieDao;
}
