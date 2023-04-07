package com.decagon.DecagonEmployeeService.repository;

import com.decagon.DecagonEmployeeService.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    Employee findEmployeeById(Long employeeId);

}
