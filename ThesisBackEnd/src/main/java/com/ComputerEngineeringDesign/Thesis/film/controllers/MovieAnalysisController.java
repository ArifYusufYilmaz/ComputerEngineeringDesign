package com.ComputerEngineeringDesign.Thesis.film.controllers;

import com.ComputerEngineeringDesign.Thesis.film.services.abstracts.MovieAnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movieAnalyses")
@RequiredArgsConstructor
public class MovieAnalysisController {
    private final MovieAnalysisService movieAnalysisService;

}
