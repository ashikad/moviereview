package com.example.moviedata.movie_catalog_service.controllers;

import com.example.moviedata.movie_catalog_service.models.CatalogItem;
import com.example.moviedata.movie_catalog_service.models.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        List<Rating> ratings = Arrays.asList(
                new Rating("test1",4),
                new Rating("test2",3)
        );

        return Collections.singletonList(
                new CatalogItem("Avengers","action movie",4)
        );

    }

}
