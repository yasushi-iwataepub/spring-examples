package org.springframework.amqp.daemon;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

@RabbitListener(queues = "hello")
public class Receiver {

    @RabbitHandler
    public void receive(byte[] message) {
    	String in = new String(message);
       System.out.println(" [x] Received '" + in + "'");
    }
}
