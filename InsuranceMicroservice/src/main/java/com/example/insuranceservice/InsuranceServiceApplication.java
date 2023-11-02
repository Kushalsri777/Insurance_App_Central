package com.example.insuranceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com")
@EnableJpaRepositories("com.example.repo")
@EntityScan("com.example.entities")
public class InsuranceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceServiceApplication.class, args);
	}

}
