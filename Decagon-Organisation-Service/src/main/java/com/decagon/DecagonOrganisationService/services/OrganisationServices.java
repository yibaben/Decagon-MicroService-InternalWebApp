package com.decagon.DecagonOrganisationService.services;

import com.decagon.DecagonOrganisationService.dto.OrganisationDto;

public interface OrganisationServices {
    OrganisationDto saveOrganisation(OrganisationDto organisationDto);
    OrganisationDto getOrganisationByCode(String orgCodeNum);

}
