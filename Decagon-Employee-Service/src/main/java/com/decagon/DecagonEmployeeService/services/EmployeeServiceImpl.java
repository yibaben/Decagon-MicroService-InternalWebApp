package com.decagon.DecagonEmployeeService.services;

import com.decagon.DecagonEmployeeService.dto.APIResponseDto;
import com.decagon.DecagonEmployeeService.dto.DepartmentDto;
import com.decagon.DecagonEmployeeService.dto.EmployeeDto;
import com.decagon.DecagonEmployeeService.entity.Employee;
import com.decagon.DecagonEmployeeService.exception.EmailAlreadyExistException;
import com.decagon.DecagonEmployeeService.exception.ResourceNotFoundException;
import com.decagon.DecagonEmployeeService.mapper.AutoMapper;
import com.decagon.DecagonEmployeeService.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    // private RestTemplate restTemplate;
    // private WebClient webClient;
    private APIClient apiClient;

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
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", employeeId)
        );

//        REST API Call Using RestTemplate
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
//                "http://localhost:8080/api/department/get/"
//                + employee.getDepartmentCode(),
//                DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();

//         REST API Call Using WebClient
//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/department/get/"
//                + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

        // REST API Call Using Spring Cloud OpenFeign
        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        // Convert Employee Jpa Entity to EmployeeDto Using ModelMapper
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;

        // Convert Employee Jpa Entity to EmployeeDto Using MapStruct
        // return AutoMapper.MAPPER.mapToEmployeeDto(employee);

    }
}
