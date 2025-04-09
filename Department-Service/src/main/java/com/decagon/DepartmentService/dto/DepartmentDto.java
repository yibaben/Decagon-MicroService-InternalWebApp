package com.decagon.DepartmentService.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "DepartmentDto Model information")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    private Long id;
    @Schema(description = "Department Name")
    private String name;
    @Schema(description = "Department Description")
    private String description;
    @Schema(description = "Department Code Number")
    private String code;
}
