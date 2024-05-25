package com.example.moviedata.ratings_data_service.controllers;

import com.example.moviedata.ratings_data_service.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsController {

    @RequestMapping("/movieId")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId,2);
    }

}
