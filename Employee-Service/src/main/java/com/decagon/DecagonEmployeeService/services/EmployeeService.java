package com.decagon.DecagonEmployeeService.services;

import com.decagon.DecagonEmployeeService.dto.APIResponseDto;
import com.decagon.DecagonEmployeeService.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
