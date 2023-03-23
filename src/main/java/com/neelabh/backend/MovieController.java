package com.neelabh.backend;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/vi/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovieByImdbID(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.findMovieByImdbId(imdbId), HttpStatus.OK);
    }

//TO DO - implement service to show all reviews of a movie
//    @GetMapping("/{imdbId}/reviews")
//    public ResponseEntity<Optional<List<Review>>> getReviews(@RequestParam String imdbId){
//        Optional<Movie> movie = movieService.findMovieByImdbId(imdbId);
//        List<Review> reviews = new ArrayList<Review>();
//        if(movie.isPresent())reviews = movie.get().getReviewIds();
//        return new ResponseEntity<Optional<List<Review>>>(reviews);
//    }
}
