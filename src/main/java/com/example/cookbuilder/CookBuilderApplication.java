package com.example.cookbuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CookBuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CookBuilderApplication.class, args);
	}
	@Bean
	public RestTemplate getRestTemplate(){return new RestTemplate();}

}
