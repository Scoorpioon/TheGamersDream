package com.gamerdream.backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	@Value("${spring.dale}") private String env;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
}