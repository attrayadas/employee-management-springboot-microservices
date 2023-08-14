package com.attraya.organizationservice;

import com.attraya.organizationservice.entity.Organization;
import com.attraya.organizationservice.repository.OrganizationRepository;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Organization Service REST APIs",
				description = "Organization Service REST APIs Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Attraya",
						email = "attrayaghoshdas@gmail.com"
				),
				license = @License(
						name = "Apache 2.0"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Organization-Service Doc"
		)
)
@SpringBootApplication
public class OrganizationServiceApplication implements CommandLineRunner {

	@Autowired
	private OrganizationRepository organizationRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		organizationRepository.deleteAll();

		Organization organization = new Organization();
		organization.setOrganizationName("TCS");
		organization.setOrganizationCode("TCS");
		organization.setOrganizationDescription("Tata Consultancy Services Ltd - IT");
		organizationRepository.save(organization);

	}
}
