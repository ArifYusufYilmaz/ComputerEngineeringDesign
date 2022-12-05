package com.ComputerEngineeringDesign.Thesis.film.services.concretes;

import com.ComputerEngineeringDesign.Thesis.film.repositories.MovieAnalysisDao;
import com.ComputerEngineeringDesign.Thesis.film.services.abstracts.MovieAnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieAnalysisServiceImpl implements MovieAnalysisService {
    private final MovieAnalysisDao movieAnalysisDao;
}
