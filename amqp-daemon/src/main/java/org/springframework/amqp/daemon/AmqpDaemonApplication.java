package org.springframework.amqp.daemon;

import java.util.concurrent.CountDownLatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
public class AmqpDaemonApplication {

	@Bean
	public CountDownLatch closeLatch() {
	    return new CountDownLatch(1);
	}
	
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx = SpringApplication.run(AmqpDaemonApplication.class, args);
		
		// https://stackoverflow.com/a/36065113
	    final CountDownLatch closeLatch = ctx.getBean(CountDownLatch.class);
	    Runtime.getRuntime().addShutdownHook(new Thread() {
	        @Override
	        public void run() {
	            closeLatch.countDown();
	        }
	    });
	    closeLatch.await();
	}
}
