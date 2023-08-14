package com.attraya.departmentservice;

import com.attraya.departmentservice.entity.Department;
import com.attraya.departmentservice.repository.DepartmentRepository;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
		info = @Info(
				title = "Department Service REST APIs",
				description = "Department Service REST APIs Documentation",
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
				description = "Department-Service Doc"
		)
)
@SpringBootApplication // @EnableEurekaClient - This annotation was removed in spring cloud 2022.0.0 and provided auto-configuration
public class DepartmentServiceApplication implements CommandLineRunner {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Autowired
	private DepartmentRepository departmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Department department = new Department();
		department.setDepartmentName("IT");
		department.setDepartmentCode("IT101");
		department.setDepartmentDescription("Information Technology");
		departmentRepository.save(department);
	}
}
