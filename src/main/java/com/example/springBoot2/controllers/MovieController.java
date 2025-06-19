package com.example.springBoot2.controllers;

import com.example.springBoot2.Repositories.MovieRepository;
import com.example.springBoot2.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable(value="id") int movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }

    @PostMapping("")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable(value="id") int movieId, @RequestBody Movie movie) {
        movie.setId(movieId);
        return movieRepository.save(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable(value="id") int id) {
        movieRepository.findById(id).ifPresent(currMovie -> movieRepository.deleteById(id));
    }
}
