package com.decagon.DecagonEmployeeService.services;

import com.decagon.DecagonEmployeeService.dto.EmployeeDto;
import com.decagon.DecagonEmployeeService.entity.Employee;
import com.decagon.DecagonEmployeeService.exception.EmailAlreadyExistException;
import com.decagon.DecagonEmployeeService.exception.ResourceNotFoundException;
import com.decagon.DecagonEmployeeService.mapper.AutoMapper;
import com.decagon.DecagonEmployeeService.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Optional<Employee> optionalEmployee = employeeRepository.findEmployeeByEmail(employeeDto.getEmail());
        if (optionalEmployee.isPresent()){
            throw new EmailAlreadyExistException("This Email Already Exist");
        }

        // Convert EmployeeDto to Jpa Entity and save into Database
        // Using ModelMapper
        Employee newEmployee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(newEmployee);

        // Convert EmployeeDto to Jpa Entity and save into Database
        // Using MapStruct
        // Employee newEmployee = AutoMapper.MAPPER.mapToEmployee(employeeDto);
        // Employee saveEmployee = employeeRepository.save(newEmployee);

        // Convert SavedEmployee Jpa Entity in the DB to EmployeeDto for Client Request
        // Using ModelMapper
        return modelMapper.map(savedEmployee, EmployeeDto.class);

        // Convert SavedEmployee Jpa Entity in the DB to EmployeeDto for Client Request
        // Using MapStruct
        // EmployeeDto savedEmployeeDto =AutoMapper.MAPPER.mapToEmployeeDto(saveEmployee);
        // return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", employeeId)
        );


        // Convert Employee Jpa Entity to EmployeeDto Using ModelMapper
        return modelMapper.map(employee, EmployeeDto.class);

        // Convert Employee Jpa Entity to EmployeeDto Using MapStruct
        // return AutoMapper.MAPPER.mapToEmployeeDto(employee);

    }
}
