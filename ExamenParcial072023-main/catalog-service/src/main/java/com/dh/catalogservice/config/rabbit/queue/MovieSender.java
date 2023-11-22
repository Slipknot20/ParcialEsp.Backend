package com.dh.catalogservice.config.rabbit.queue;

import com.dh.catalogservice.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieSender {
    private final RabbitTemplate rabbitTemplate;
    private final Queue AgregarMovieQueu;
    public void send(Movie movie) {
        this.rabbitTemplate.convertAndSend(this.AgregarMovieQueu.getName(), movie);
    }

}
