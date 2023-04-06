package com.decagon.DepartmentService.controller;

import com.decagon.DepartmentService.dto.DepartmentDto;
import com.decagon.DepartmentService.repository.DepartmentRepository;
import com.decagon.DepartmentService.services.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/department")
public class DepartmentController {

    private DepartmentService departmentService;

    // Build Save Department REST API
    @PostMapping("save")
    public ResponseEntity<DepartmentDto> savedDepartments(@RequestBody DepartmentDto departmentDto){
        DepartmentDto newDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(newDepartment, HttpStatus.CREATED);
    }

    // Build Get Department REST API
    @GetMapping("get/{code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("code") String departmentCode){
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

}
