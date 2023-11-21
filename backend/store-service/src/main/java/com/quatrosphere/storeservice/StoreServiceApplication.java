package com.quatrosphere.storeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages =  {
	"com.quatrosphere.apipublica.services",
	"com.quatrosphere.apipublica.controllers",
	"com.quatrosphere.apipublica.config",
})
@EnableJpaRepositories(basePackages = "com.quatrosphere.apipublica.repositories")
public class StoreServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreServiceApplication.class, args);
	}

}
