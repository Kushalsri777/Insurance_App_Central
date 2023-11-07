package com.example.insurancecartmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@ComponentScan("com")
@EntityScan("com.example.entity")
@EnableJpaRepositories("com.example.repo")
@OpenAPIDefinition(info = @Info(title = "Insurance Cart API", description = "Manage Insurance Cart", version = ""))
public class InsuranceCartMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceCartMicroserviceApplication.class, args);
	}

}
