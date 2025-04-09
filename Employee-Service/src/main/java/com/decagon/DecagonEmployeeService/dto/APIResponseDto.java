package com.decagon.DecagonEmployeeService.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "APIResponseDto Model information")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    @Schema(description = "Employee Info")
    private EmployeeDto employee;
    @Schema(description = "Department Info")
    private DepartmentDto department;
    @Schema(description = "Organisation Info")
    private OrganisationDto organisation;
}
