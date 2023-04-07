package com.decagon.DepartmentService.services.impl;

import com.decagon.DepartmentService.dto.DepartmentDto;
import com.decagon.DepartmentService.entity.Department;
import com.decagon.DepartmentService.mapper.AutoMapper;
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
        // Using ModelMapper
        Department department = modelMapper.map(departmentDto, Department.class);
        Department saveDepartment = departmentRepository.save(department);

        // Convert DepartmentDto to Department JPA Entity Using MapStruct
        // Department newDepartment = AutoMapper.MAPPER.mapToDepartment(departmentDto);
        // Department saveDepartment = departmentRepository.save(newDepartment);

        // Convert Back the Saved Department Jpa Entity into DepartmentDto for client request
        // Using ModelMapper
        DepartmentDto savedDepartmentDto = modelMapper.map(saveDepartment, DepartmentDto.class);
        return savedDepartmentDto;

        // Convert Department JPA Entity to DepartmentDto Using MapStruct
        // return AutoMapper.MAPPER.mapToDepartmentDto(saveDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findDepartmentByCode(departmentCode);

        // Convert Department Jpa Entity to DepartmentDto Using ModelMapper
         return modelMapper.map(department, DepartmentDto.class);

        // Convert Saved Department JPA Entity to DepartmentDto Using MapStruct
        // return AutoMapper.MAPPER.mapToDepartmentDto(department);
    }
}
