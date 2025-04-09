package com.decagon.DecagonOrganisationService;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@OpenAPIDefinition(
		info = @Info(
				title = "Organisation-Service REST APIs",
				description = "Organisation Service REST APIs Documentation",
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
				description = "Organisation Service Doc",
				url = "https://www.decagonhq.com.it"
		)
)
@SpringBootApplication
//@EnableEurekaClient
public class DecagonOrganisationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DecagonOrganisationServiceApplication.class, args);
	}

}
