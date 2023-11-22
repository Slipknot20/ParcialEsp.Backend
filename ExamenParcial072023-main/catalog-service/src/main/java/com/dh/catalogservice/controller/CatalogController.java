package com.dh.catalogservice.controller;

import com.dh.catalogservice.client.IMovieClient;
import com.dh.catalogservice.client.ISerieClient;
import com.dh.catalogservice.model.Movie;
import com.example.serieservice.model.Serie;
import com.example.serieservice.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatalogController {
    private static SerieService serieService;

    @Autowired
    private IMovieClient iMovieClient;

    @Autowired
    private ISerieClient iSerieClient;

    @GetMapping("catalog/{genre}")
    public ResponseEntity<List<Movie>> getCatalogByGenre (@PathVariable String genre){
        return iMovieClient.getMovieByGenre(genre);
    }

    @GetMapping("/{genre}")
    public List<Serie> getSerieByGenre(@PathVariable String genre) {
        return serieService.getSeriesBygGenre(genre);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    static String create(
            @RequestBody Serie serie
    ) {
        CatalogController.serieService.create(serie);
        return serie.getId();
    }
}
