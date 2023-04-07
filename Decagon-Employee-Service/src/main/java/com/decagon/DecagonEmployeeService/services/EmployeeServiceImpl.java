package com.decagon.DecagonEmployeeService.services;

import com.decagon.DecagonEmployeeService.dto.EmployeeDto;
import com.decagon.DecagonEmployeeService.entity.Employee;
import com.decagon.DecagonEmployeeService.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        // Convert EmployeeDto to Jpa Entity and save into Database
//        Employee newEmployee = new Employee(
//                employeeDto.getId(),
//                employeeDto.getFirstName(),
//                employeeDto.getLastName(),
//                employeeDto.getEmail(),
//                employeeDto.getPassword()
//        );

        // Convert EmployeeDto to Jpa Entity and save into Database
        // Using ModelMapper
        Employee newEmployee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(newEmployee);

        // Convert SavedEmployee Jpa Entity in the DB to EmployeeDto for Client Request
//        EmployeeDto employee = new EmployeeDto(
//                savedEmployee.getId(),
//                savedEmployee.getFirstName(),
//                savedEmployee.getLastName(),
//                savedEmployee.getEmail(),
//                savedEmployee.getPassword()
//        );

        // Convert SavedEmployee Jpa Entity in the DB to EmployeeDto for Client Request
        // Using ModelMapper
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

        // Convert Employee Jpa Entity to EmployeeDto
//        EmployeeDto employeeDto = new EmployeeDto(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail(),
//                employee.getPassword()
//        );

        // Convert Employee Jpa Entity to EmployeeDto Using ModelMapper
        return modelMapper.map(employee, EmployeeDto.class);
    }
}
