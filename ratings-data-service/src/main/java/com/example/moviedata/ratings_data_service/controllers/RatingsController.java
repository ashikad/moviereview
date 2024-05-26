package com.example.moviedata.ratings_data_service.controllers;

import com.example.moviedata.ratings_data_service.models.Rating;
import com.example.moviedata.ratings_data_service.models.UserRating;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsController {

    @RequestMapping("/movieId")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId,2);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId){
        List<Rating> ratings =  Arrays.asList(
                new Rating("test1",2),
                new Rating("test2",4)
        );
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);

        return userRating;
    }

}
