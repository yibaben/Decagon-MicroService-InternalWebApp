package com.decagon.DecagonOrganisationService.controller;

import com.decagon.DecagonOrganisationService.dto.OrganisationDto;
import com.decagon.DecagonOrganisationService.entity.Organisation;
import com.decagon.DecagonOrganisationService.services.OrganisationServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
