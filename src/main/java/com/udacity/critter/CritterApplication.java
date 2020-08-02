package com.udacity.critter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CritterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CritterApplication.class, args);
	}

}
