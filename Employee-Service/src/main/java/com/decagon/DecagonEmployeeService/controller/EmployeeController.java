package com.decagon.DecagonEmployeeService.controller;

import com.decagon.DecagonEmployeeService.dto.APIResponseDto;
import com.decagon.DecagonEmployeeService.dto.EmployeeDto;
import com.decagon.DecagonEmployeeService.services.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Employee-Service - EmployeeController",
        description = "Exposes REST APIs for Employee-Service"
)
@AllArgsConstructor
@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    // Build Save Employee REST API
    @Operation(
            summary = "Save new Employee REST API",
            description = "This REST API is used to save new Employee object in a Database"
    )
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")
    @PostMapping("save")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto newEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    // Build Get Employee REST API
    @Operation(
            summary = "Get Employee REST API",
            description = "This REST API is used to Get or Retrieve Employee object from the Database"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
    @GetMapping("get/{id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable Long id){
        APIResponseDto apiResponseDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.FOUND);
    }
}
