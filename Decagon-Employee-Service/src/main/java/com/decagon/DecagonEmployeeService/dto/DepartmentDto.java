package com.decagon.DecagonEmployeeService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    private Long id;
    private String name;
    private String description;
    private String code;
}
