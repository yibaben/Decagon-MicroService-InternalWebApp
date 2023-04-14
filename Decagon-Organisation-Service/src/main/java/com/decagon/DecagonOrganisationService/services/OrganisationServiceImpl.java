package com.decagon.DecagonOrganisationService.services;

import com.decagon.DecagonOrganisationService.dto.OrganisationDto;
import com.decagon.DecagonOrganisationService.entity.Organisation;
import com.decagon.DecagonOrganisationService.mapper.OrganisationMapper;
import com.decagon.DecagonOrganisationService.repository.OrganisationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class OrganisationServiceImpl implements OrganisationServices{

    private OrganisationRepository organisationRepository;
    @Override
    public OrganisationDto saveOrganisation(OrganisationDto organisationDto) {
        // Convert EmployeeDto to Jpa Entity and save into Database
        // Using Mapper class
        Organisation newOrganisation = OrganisationMapper.mapToOrganisation(organisationDto);
        Organisation saveOrganisation = organisationRepository.save(newOrganisation);

        // Convert Organisation JPA Entity to OrganisationDto and return to the client
        return OrganisationMapper.mapToOrganisationDto(saveOrganisation);
    }

    @Override
    public OrganisationDto getOrganisationByCode(String orgCodeNum) {
        Organisation organisation = organisationRepository.findByOrgCodeNum(orgCodeNum);
        // Convert Organisation JPA Entity to OrganisationDto and return to the client
        return OrganisationMapper.mapToOrganisationDto(organisation);
    }
}
