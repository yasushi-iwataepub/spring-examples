package org.springframework.amqp.daemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
public class AmqpDaemonApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmqpDaemonApplication.class, args);
	}
	
	@Bean(name = "threadPoolTaskExecutor")
	public ThreadPoolTaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
		pool.setCorePoolSize(3);
		pool.setMaxPoolSize(10);
		pool.setWaitForTasksToCompleteOnShutdown(false);
		return pool;
	}
}
