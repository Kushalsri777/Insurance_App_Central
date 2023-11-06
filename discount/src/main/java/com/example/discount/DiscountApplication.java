package com.example.discount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com")
@EntityScan("com.entity")
@EnableJpaRepositories("com.repo")
//@EnableEurekaClient
public class DiscountApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscountApplication.class, args);
	}

}
