package com.dh.catalogservice.config.rabbit.controller;

import com.dh.catalogservice.config.rabbit.queue.MovieSender;
import com.dh.catalogservice.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegistroRestController {
    private final MovieSender sender;

    @PostMapping("/save"){
        public ResponseEntity<?> saveMovie(@RequestBody Movie movie){
            sender.send(movie);
            return ResponseEntity.noContent().build();
        }
    }
}
