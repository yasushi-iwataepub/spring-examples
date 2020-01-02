package com.iwataepub;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
public class MyRunner implements CommandLineRunner {

	private static final Logger logger = LogManager.getLogger(MyRunner.class);

	@Override
	public void run(String... args) throws Exception {
		logger.debug("=== ths is debug message ===");
		
	}

}
