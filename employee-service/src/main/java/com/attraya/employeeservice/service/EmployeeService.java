package com.attraya.employeeservice.service;

import com.attraya.employeeservice.dto.APIResponseDto;
import com.attraya.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long employeeId);
}
