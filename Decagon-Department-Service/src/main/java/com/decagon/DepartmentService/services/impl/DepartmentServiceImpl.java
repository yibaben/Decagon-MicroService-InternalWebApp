package com.decagon.DepartmentService.services.impl;

import com.decagon.DepartmentService.dto.DepartmentDto;
import com.decagon.DepartmentService.entity.Department;
import com.decagon.DepartmentService.repository.DepartmentRepository;
import com.decagon.DepartmentService.services.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        // Convert DepartmentDto into Department Jpa Entity and save in database
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getName(),
                departmentDto.getDescription(),
                departmentDto.getCode()
        );
        Department saveDepartment = departmentRepository.save(department);

        // Convert Back the Saved Department Jpa Entity into DepartmentDto for client request
        DepartmentDto savedDepartmentDto = new DepartmentDto(
                saveDepartment.getId(),
                saveDepartment.getName(),
                saveDepartment.getDescription(),
                saveDepartment.getCode()
        );
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findDepartmentByCode(departmentCode);

        // Convert Department Jpa Entity to DepartmentDto
        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getName(),
                department.getDescription(),
                department.getCode()
        );
        return departmentDto;
    }
}
