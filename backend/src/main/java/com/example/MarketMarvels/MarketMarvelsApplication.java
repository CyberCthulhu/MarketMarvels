package com.example.MarketMarvels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;



@SpringBootApplication
public class MarketMarvelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketMarvelsApplication.class, args);
	}
}



// http://localhost:8000/swagger-ui/index.html#/customer-controller/getAllUsers

// API to GET all users: http://localhost:8000/api/users

// API to GET users by first name: http://localhost:8000/api/users/{firstName}

//API to get users by id: http://localhost:8000/api/users/id/{id}