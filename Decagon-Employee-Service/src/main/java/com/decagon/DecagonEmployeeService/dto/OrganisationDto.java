package com.decagon.DecagonEmployeeService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganisationDto {

    private Long id;

    private String orgName;

    private String orgDescription;

    private  String orgCodeNum;

    private LocalDateTime createdDate;
}
