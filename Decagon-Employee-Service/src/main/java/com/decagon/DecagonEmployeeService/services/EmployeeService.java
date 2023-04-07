package com.decagon.DecagonEmployeeService.services;

import com.decagon.DecagonEmployeeService.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);
}
