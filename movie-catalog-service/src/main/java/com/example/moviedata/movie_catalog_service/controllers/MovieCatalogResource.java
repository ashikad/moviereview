package com.example.moviedata.movie_catalog_service.controllers;

import com.example.moviedata.movie_catalog_service.models.CatalogItem;
import com.example.moviedata.movie_catalog_service.models.MovieInfo;
import com.example.moviedata.movie_catalog_service.models.Rating;
import com.example.moviedata.movie_catalog_service.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/"+userId, UserRating.class);

        return ratings.getUserRating().stream().map(rating -> {
                MovieInfo movieInfo = restTemplate.getForObject("http://localhost:8082/info/foo", MovieInfo.class);
                return new CatalogItem(movieInfo.getName(),"Test",rating.getRating());
        })
                .collect(Collectors.toList());

//        return Collections.singletonList(
//                new CatalogItem("Avengers","action movie",4)
//        );

    }

}
