package com.attraya.employeeservice;

import com.attraya.employeeservice.entity.Employee;
import com.attraya.employeeservice.repository.EmployeeRepository;
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
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@OpenAPIDefinition(
		info = @Info(
				title = "Employee Service REST APIs",
				description = "Employee Service REST APIs Documentation",
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
				description = "Employee-Service Doc"
		)
)
@SpringBootApplication
@EnableFeignClients // @EnableEurekaClient - This annotation was removed in spring cloud 2022.0.0 and provided auto-configuration
public class EmployeeServiceApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

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

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee();
		employee.setFirstName("Attraya");
		employee.setLastName("Das");
		employee.setEmail("attrayaghoshdas@gmail.com");
		employee.setDepartmentCode("IT101");
		employee.setOrganizationCode("TCS");
		employeeRepository.save(employee);
	}
}
