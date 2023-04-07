package com.decagon.DepartmentService.services.impl;

import com.decagon.DepartmentService.dto.DepartmentDto;
import com.decagon.DepartmentService.entity.Department;
import com.decagon.DepartmentService.repository.DepartmentRepository;
import com.decagon.DepartmentService.services.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private ModelMapper modelMapper;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        // Convert DepartmentDto into Department Jpa Entity and save in database
//        Department department = new Department(
//                departmentDto.getId(),
//                departmentDto.getName(),
//                departmentDto.getDescription(),
//                departmentDto.getCode()
//        );

        // Convert DepartmentDto into Department Jpa Entity and save in database
        // Using ModelMapper
        Department department = modelMapper.map(departmentDto, Department.class);
        Department saveDepartment = departmentRepository.save(department);

        // Convert Back the Saved Department Jpa Entity into DepartmentDto for client request
//        DepartmentDto savedDepartmentDto = new DepartmentDto(
//                saveDepartment.getId(),
//                saveDepartment.getName(),
//                saveDepartment.getDescription(),
//                saveDepartment.getCode()
//        );

        // Convert Back the Saved Department Jpa Entity into DepartmentDto for client request
        // Using ModelMapper
        DepartmentDto savedDepartmentDto = modelMapper.map(saveDepartment, DepartmentDto.class);
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findDepartmentByCode(departmentCode);

        // Convert Department Jpa Entity to DepartmentDto
//        DepartmentDto departmentDto = new DepartmentDto(
//                department.getId(),
//                department.getName(),
//                department.getDescription(),
//                department.getCode()
//        );

        // Convert Department Jpa Entity to DepartmentDto Using ModelMapper
//        DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);
//        return departmentDto;
        return modelMapper.map(department, DepartmentDto.class);
    }
}
