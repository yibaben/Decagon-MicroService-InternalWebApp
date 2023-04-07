package com.decagon.DepartmentService.repository;

import com.decagon.DepartmentService.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findDepartmentByCode(String departmentCode);

}
