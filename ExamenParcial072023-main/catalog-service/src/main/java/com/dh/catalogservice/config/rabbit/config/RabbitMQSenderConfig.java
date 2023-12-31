package com.dh.catalogservice.config.rabbit.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.annotation.Queue;

@Configuration
public class RabbitMQSenderConfig {

    @Value("${queue.movie.name}")
    private String AgregarMovieQueu;

    @Bean
    public Queue queue() {
        return new Queue(this.AgregarMovieQueu, true);
    }
}
