package com.decagon.DecagonEmployeeService.mapper;

import com.decagon.DecagonEmployeeService.dto.EmployeeDto;
import com.decagon.DecagonEmployeeService.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoMapper {

    AutoMapper MAPPER = Mappers.getMapper(AutoMapper.class);
    EmployeeDto mapToEmployeeDto(Employee employee);
    Employee mapToEmployee(EmployeeDto employeeDto);

}
