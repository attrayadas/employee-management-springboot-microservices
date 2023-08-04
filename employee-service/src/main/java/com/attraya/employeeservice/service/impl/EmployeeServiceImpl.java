package com.attraya.employeeservice.service.impl;

import com.attraya.employeeservice.dto.APIResponseDto;
import com.attraya.employeeservice.dto.DepartmentDto;
import com.attraya.employeeservice.dto.EmployeeDto;
import com.attraya.employeeservice.entity.Employee;
import com.attraya.employeeservice.exception.ResourceNotFoundException;
import com.attraya.employeeservice.repository.EmployeeRepository;
import com.attraya.employeeservice.service.APIClient;
import com.attraya.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

//    private RestTemplate restTemplate;

//    private WebClient webClient;

    private APIClient apiClient;

    private ModelMapper mapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = mapper.map(employeeDto, Employee.class);

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = mapper.map(savedEmployee, EmployeeDto.class);

        return savedEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));

        /** Using RestTemplate */
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
//                DepartmentDto.class);
//
//        DepartmentDto departmentDto = responseEntity.getBody();

        /** Using WebClient */
//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//                .retrieve().bodyToMono(DepartmentDto.class)
//                .block();

        /** Using FeignClient */
        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
}
