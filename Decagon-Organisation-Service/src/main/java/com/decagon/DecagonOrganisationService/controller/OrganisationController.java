package com.decagon.DecagonOrganisationService.controller;

import com.decagon.DecagonOrganisationService.dto.OrganisationDto;
import com.decagon.DecagonOrganisationService.entity.Organisation;
import com.decagon.DecagonOrganisationService.services.OrganisationServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Organisation-Service - OrganisationController",
        description = "Exposes REST APIs for Organisation-Service"
)
@AllArgsConstructor
@RestController
@RequestMapping("api/organisation")
public class OrganisationController {

    private OrganisationServices organisationServices;

    // Build Save Employee REST API
    @Operation(
            summary = "Save new Organisation REST API",
            description = "This REST API is used to save new Organisation object in a Database"
    )
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")
    @PostMapping("save")
    public ResponseEntity<OrganisationDto> saveOrganisation(@RequestBody OrganisationDto organisationDto){
        OrganisationDto savedOrganisation = organisationServices.saveOrganisation(organisationDto);
        return new ResponseEntity<>(savedOrganisation, HttpStatus.CREATED);
    }


    // Build Get Employee REST API
    @Operation(
            summary = "Get Organisation REST API",
            description = "This REST API is used to Get or Retrieve Organisation object from the Database"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
    @GetMapping("get/{code}")
    public ResponseEntity<OrganisationDto> getOrganisationByCode(@PathVariable("code") String orgCodeNum){
        OrganisationDto organisationDto = organisationServices.getOrganisationByCode(orgCodeNum);
        return ResponseEntity.ok(organisationDto);
    }
}
