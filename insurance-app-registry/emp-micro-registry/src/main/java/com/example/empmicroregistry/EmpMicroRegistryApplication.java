package com.example.empmicroregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EmpMicroRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpMicroRegistryApplication.class, args);
	}

}
