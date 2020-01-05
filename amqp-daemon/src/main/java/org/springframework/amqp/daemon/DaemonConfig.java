package org.springframework.amqp.daemon;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaemonConfig {

    @Bean
    public Queue hello() {
        return new Queue("hello");
    }

    @Bean
    public Receiver receiver() {
        return new Receiver();
    }
}