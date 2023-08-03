package com.attraya.employeeservice.service.impl;

import com.attraya.employeeservice.dto.EmployeeDto;
import com.attraya.employeeservice.entity.Employee;
import com.attraya.employeeservice.exception.ResourceNotFoundException;
import com.attraya.employeeservice.repository.EmployeeRepository;
import com.attraya.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private ModelMapper mapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = mapper.map(employeeDto, Employee.class);

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = mapper.map(savedEmployee, EmployeeDto.class);

        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));

        EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);

        return employeeDto;
    }
}
