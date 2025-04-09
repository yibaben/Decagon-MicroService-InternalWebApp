package com.decagon.DecagonEmployeeService.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Schema(description = "OrganisationDto Model information")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganisationDto {

    private Long id;
    @Schema(description = "Organisation Name")
    private String orgName;
    @Schema(description = "Organisation Description")
    private String orgDescription;
    @Schema(description = "Organisation Code Number")
    private  String orgCodeNum;
    @Schema(description = "Organisation Date Created")
    private LocalDateTime createdDate;
}
