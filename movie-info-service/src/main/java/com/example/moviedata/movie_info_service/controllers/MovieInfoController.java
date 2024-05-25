package com.example.moviedata.movie_info_service.controllers;

import com.example.moviedata.movie_info_service.models.MovieInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class MovieInfoController {

    @RequestMapping("/{movieId}")
    public MovieInfo getMovieInfo(@PathVariable("movieId") String movieId){
            return new MovieInfo(movieId,"Test Name");
    }


}
