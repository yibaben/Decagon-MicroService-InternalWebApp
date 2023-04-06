package com.decagon.DepartmentService.repository;

import com.decagon.DepartmentService.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
