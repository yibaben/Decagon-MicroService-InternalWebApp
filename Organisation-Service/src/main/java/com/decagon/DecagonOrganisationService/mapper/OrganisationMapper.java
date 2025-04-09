package com.decagon.DecagonOrganisationService.mapper;

import com.decagon.DecagonOrganisationService.dto.OrganisationDto;
import com.decagon.DecagonOrganisationService.entity.Organisation;

public class OrganisationMapper {

    // Convert Organisation JPA Entity Stored in Database to OrganisationDto class for Client Request
    public static OrganisationDto mapToOrganisationDto(Organisation organisation){
        OrganisationDto organisationDto = new OrganisationDto(
                organisation.getId(),
                organisation.getOrgName(),
                organisation.getOrgDescription(),
                organisation.getOrgCodeNum(), 
                organisation.getCreatedDate()
        );
        return organisationDto;
    }

    // Convert OrganisationDto class to Organisation JPA Entity to Store in the Database
    public static Organisation mapToOrganisation(OrganisationDto organisationDto){
        Organisation organisation = new Organisation(
                organisationDto.getId(),
                organisationDto.getOrgName(),
                organisationDto.getOrgDescription(),
                organisationDto.getOrgCodeNum(),
                organisationDto.getCreatedDate()
        );
        return organisation;
    }
}
