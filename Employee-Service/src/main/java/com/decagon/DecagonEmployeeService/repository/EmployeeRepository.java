package com.decagon.DecagonEmployeeService.repository;

import com.decagon.DecagonEmployeeService.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findEmployeeByEmail(String email);

}
