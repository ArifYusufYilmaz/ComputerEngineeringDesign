package com.ComputerEngineeringDesign.Thesis.film.controllers;

import com.ComputerEngineeringDesign.Thesis.film.services.abstracts.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;


}
