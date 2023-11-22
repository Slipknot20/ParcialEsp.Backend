package com.dh.catalogservice.client;

import com.example.serieservice.model.Serie;
import com.example.serieservice.service.SerieService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "serie-service")
public interface ISerieClient {
    @GetMapping("/{genre}")
    List<Serie> getSerieByGenre(@PathVariable String genre);
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    static String create(
            @RequestBody Serie serie
    ) {
        return null;
    }
}
