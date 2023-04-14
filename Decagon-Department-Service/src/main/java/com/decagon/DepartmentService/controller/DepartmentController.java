package com.decagon.DepartmentService.controller;

import com.decagon.DepartmentService.dto.DepartmentDto;
import com.decagon.DepartmentService.repository.DepartmentRepository;
import com.decagon.DepartmentService.services.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Department-Service - DepartmentController",
        description = "Exposes REST APIs for Department-Service"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/department")
public class DepartmentController {

    private DepartmentService departmentService;

    // Build Save Department REST API
    @Operation(
            summary = "Save new Department REST API",
            description = "This REST API is used to save new Department object in a Database"
    )
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")
    @PostMapping("save")
    public ResponseEntity<DepartmentDto> savedDepartments(@RequestBody DepartmentDto departmentDto){
        DepartmentDto newDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(newDepartment, HttpStatus.CREATED);
    }

    // Build Get Department REST API
    @Operation(
            summary = "Get Department REST API",
            description = "This REST API is used to Get or Retrieve Department object from the Database"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
    @GetMapping("get/{code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("code") String departmentCode){
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

}
