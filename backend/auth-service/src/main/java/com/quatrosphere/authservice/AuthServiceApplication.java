package com.quatrosphere.authservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.quatrosphere.authservice.services",
		"com.quatrosphere.authservice.controllers",
		"com.quatrosphere.authservice.configs",
		"com.quatrosphere.authservice.mapers"
	})
@EnableJpaRepositories(basePackages = "com.quatrosphere.authservice.repositories")
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

}
