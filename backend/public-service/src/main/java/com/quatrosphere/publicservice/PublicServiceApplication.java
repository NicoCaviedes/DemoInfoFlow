package com.quatrosphere.publicservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
	"com.quatrosphere.publicservice.services",
	"com.quatrosphere.publicservice.controllers",
	"com.quatrosphere.publicservice.config",
	"com.quatrosphere.publicservice.mappers"
})
@EnableJpaRepositories(basePackages = "com.quatrosphere.publicservice.repositories")
public class PublicServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublicServiceApplication.class, args);
	}

}
