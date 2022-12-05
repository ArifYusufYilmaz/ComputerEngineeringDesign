package com.ComputerEngineeringDesign.Thesis.film.entities;

import javax.persistence.*;

@Entity
@Table(name="movies")
public class Movie {
        @Id
        @SequenceGenerator(name = "Movie", sequenceName = "MOVIE_ID_SEQ")
        @GeneratedValue(generator = "Movie",strategy = GenerationType.SEQUENCE)
        private Long id;
        private String movieName;
        private boolean haveBeenWatched;  // should be ENUM
        // filmURL;
        @OneToOne(mappedBy = "movie",cascade = CascadeType.ALL)
        private MovieAnalysis movieAnalysis;

}
