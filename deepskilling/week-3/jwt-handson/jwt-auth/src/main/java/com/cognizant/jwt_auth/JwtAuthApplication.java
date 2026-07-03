package com.cognizant.jwt_auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtAuthApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Starting JwtAuthApplication...");
		SpringApplication.run(JwtAuthApplication.class, args);
		LOGGER.info("JwtAuthApplication started successfully.");
	}
}