package com.decagon.DecagonEmployeeService.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "EmployeeDto Model information")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;
    @Schema(description = "Employee firstName")
    private String firstName;
    @Schema(description = "Employee lastName")
    private String lastName;
    @Schema(description = "Employee valid Email Address")
    private String email;
    @Schema(description = "Employee password")
    private String password;
    @Schema(description = "Employee Department Code Number")
    private String departmentCode;
    @Schema(description = "Employee Organisation Code Number")
    private String organisationCode;
}
