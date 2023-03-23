package com.neelabh.backend;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovie(ObjectId id){
        return movieRepository.findById(id);  //Making it optional because it may return NULL when id does not match
    }

    public Optional<Movie> findMovieByImdbId(String id){
        return movieRepository.findMovieByImdbId(id);
    }
}
