package com.decagon.DecagonEmployeeService.services;

import com.decagon.DecagonEmployeeService.dto.EmployeeDto;
import com.decagon.DecagonEmployeeService.entity.Employee;
import com.decagon.DecagonEmployeeService.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        // Convert EmployeeDto to Jpa Entity and save into Database
        Employee newEmployee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getPassword()
        );
        Employee savedEmployee = employeeRepository.save(newEmployee);

        // Convert SavedEmployee Jpa Entity in the DB to EmployeeDto for Client Request
        EmployeeDto employee = new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getPassword()
        );
        return employee;
    }
}
