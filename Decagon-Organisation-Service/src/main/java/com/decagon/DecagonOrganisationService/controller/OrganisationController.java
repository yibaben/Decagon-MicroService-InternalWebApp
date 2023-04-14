package com.decagon.DecagonOrganisationService.controller;

import com.decagon.DecagonOrganisationService.dto.OrganisationDto;
import com.decagon.DecagonOrganisationService.entity.Organisation;
import com.decagon.DecagonOrganisationService.services.OrganisationServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/organisation")
public class OrganisationController {

    private OrganisationServices organisationServices;

    @PostMapping("save")
    public ResponseEntity<OrganisationDto> saveOrganisation(@RequestBody OrganisationDto organisationDto){
        OrganisationDto savedOrganisation = organisationServices.saveOrganisation(organisationDto);
        return new ResponseEntity<>(savedOrganisation, HttpStatus.CREATED);
    }

    @GetMapping("get/{code}")
    public ResponseEntity<OrganisationDto> getOrganisationByCode(@PathVariable("code") String orgCodeNum){
        OrganisationDto organisationDto = organisationServices.getOrganisationByCode(orgCodeNum);
        return ResponseEntity.ok(organisationDto);
    }
}
