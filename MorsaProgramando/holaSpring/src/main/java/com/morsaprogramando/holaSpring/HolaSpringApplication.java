package com.morsaprogramando.holaSpring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HolaSpringApplication {

	private static Logger logger = LoggerFactory.getLogger(HolaSpringApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HolaSpringApplication.class, args);

		System.out.println("\n\tHola Spring!!! (Rama Master)");

		logger.trace("Mi mensaje trace");
		logger.debug("Mi mensaje Debug");
		logger.info("Mi mensaje Info");
		logger.warn("Mi mensaje Warn");
		logger.error("Mi mensaje Error");
	}


}
