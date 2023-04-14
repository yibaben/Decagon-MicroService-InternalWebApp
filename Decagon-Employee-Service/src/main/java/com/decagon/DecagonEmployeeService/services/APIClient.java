package com.decagon.DecagonEmployeeService.services;

import com.decagon.DecagonEmployeeService.dto.DepartmentDto;
import com.decagon.DecagonEmployeeService.dto.OrganisationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// With OpenFeign and Eureka Service Registry; Spring Cloud will Auto Implement
// LoadBalancing to available Server Instances of Department-Service Whenever
// a REST API Call is made.
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/department/get/{code}")
    DepartmentDto getDepartment(@PathVariable("code") String departmentCode);

    @GetMapping("api/organisation/get/{code}")
    OrganisationDto getOrganisation(@PathVariable("code") String organisationCode);

}
