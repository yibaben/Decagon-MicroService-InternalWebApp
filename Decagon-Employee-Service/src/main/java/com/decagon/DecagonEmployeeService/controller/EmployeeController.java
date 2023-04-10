package com.decagon.DecagonEmployeeService.controller;

import com.decagon.DecagonEmployeeService.dto.APIResponseDto;
import com.decagon.DecagonEmployeeService.dto.EmployeeDto;
import com.decagon.DecagonEmployeeService.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    // Build Save Employee REST API
    @PostMapping("save")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto newEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    // Build Get Employee REST API
    @GetMapping("get/{id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable Long id){
        APIResponseDto apiResponseDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.FOUND);
    }
}
