package com.decagon.DecagonEmployeeService.services;

import com.decagon.DecagonEmployeeService.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/department/get/{code}")
    DepartmentDto getDepartment(@PathVariable("code") String departmentCode);

}
