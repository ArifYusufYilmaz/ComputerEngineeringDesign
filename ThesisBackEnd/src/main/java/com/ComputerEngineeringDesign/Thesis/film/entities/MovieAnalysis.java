package com.ComputerEngineeringDesign.Thesis.film.entities;

import javax.persistence.*;

@Entity
@Table(name = "movie_analyses")
public class MovieAnalysis {
    @Id
    @SequenceGenerator(name = "MovieAnalysis", sequenceName = "MOVIE_ANALYSIS_ID_SEQ")
    @GeneratedValue(generator = "MovieAnalysis",strategy = GenerationType.SEQUENCE)
    private Long id;
    private String comment;
    private double rating;
    private String extraDescription;

    @OneToOne
    @JoinColumn(name="movie_id" , unique = true)
    private Movie movie;
}
