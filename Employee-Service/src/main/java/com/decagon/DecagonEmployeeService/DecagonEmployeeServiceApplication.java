package com.decagon.DecagonEmployeeService;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@OpenAPIDefinition(
		info = @Info(
				title = "Employee-Service REST APIs",
				description = "Employee Service REST APIs Documentation",
				version = "v1.0.0",
				contact = @Contact(
						name = "Bennett",
						email = "yibaben@decagon.com",
						url = "https://www.decagonhq.com.it"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.decagonhq.com.it"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Employee Service Doc",
				url = "https://www.decagonhq.com.it"
		)
)
@SpringBootApplication
@EnableFeignClients
public class DecagonEmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DecagonEmployeeServiceApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

//	@Bean
//	public RestTemplate restTemplate(){
//		return new RestTemplate();
//	}

	@Bean
	public WebClient webClient(){
		return WebClient.builder().build();
	}

}
