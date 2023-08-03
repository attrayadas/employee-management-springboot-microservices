package com.attraya.departmentservice.service.impl;

import com.attraya.departmentservice.dto.DepartmentDto;
import com.attraya.departmentservice.entity.Department;
import com.attraya.departmentservice.exception.ResourceNotFoundException;
import com.attraya.departmentservice.repository.DepartmentRepository;
import com.attraya.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private ModelMapper mapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        // convert department dto to department jpa entity
        Department department = mapper.map(departmentDto, Department.class);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = mapper.map(savedDepartment, DepartmentDto.class);
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "code", departmentCode));

        DepartmentDto departmentDto = mapper.map(department, DepartmentDto.class);

        return departmentDto;
    }
}
