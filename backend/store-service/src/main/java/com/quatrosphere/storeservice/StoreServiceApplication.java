package com.quatrosphere.storeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages =  {
	"com.quatrosphere.storeservice.services",
	"com.quatrosphere.storeservice.controllers",
	"com.quatrosphere.storeservice.config",	
	"com.quatrosphere.storeservice.mappers",
})
@EnableJpaRepositories(basePackages = "com.quatrosphere.storeservice.repositories")
public class StoreServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreServiceApplication.class, args);
	}

}
