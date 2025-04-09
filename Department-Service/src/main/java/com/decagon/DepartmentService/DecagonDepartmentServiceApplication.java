package com.decagon.DepartmentService;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
		info = @Info(
				title = "Department-Service REST APIs",
				description = "Department Service REST APIs Documentation",
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
				description = "Department Service Doc",
				url = "https://www.decagonhq.com.it"
		)
)
@SpringBootApplication
public class DecagonDepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DecagonDepartmentServiceApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
