package com.example.FeedbackMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
@EntityScan("com.entity")
//@EnableEurekaClient
public class FeedbackMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedbackMicroserviceApplication.class, args);
	}

}
