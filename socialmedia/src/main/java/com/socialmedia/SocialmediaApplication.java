package com.socialmedia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.StopWatch;

import com.socialmedia.controller.PostController;

import jakarta.persistence.Entity;

@SpringBootApplication
@EntityScan(basePackages = "com.socialmedia.model")
@EnableJpaRepositories(basePackages = "com.socialmedia.dao")
public class SocialmediaApplication {
	static Logger logger = LoggerFactory.getLogger(SocialmediaApplication.class);

	public static void main(String[] args) {
		logger.info("Main Method Start...............");
		StopWatch time = new StopWatch();
		time.start();
		SpringApplication.run(SocialmediaApplication.class, args);
		time.stop();
		logger.info("Main Method Ended in " + time.getTotalTimeSeconds() + " seconds");
	}

}
