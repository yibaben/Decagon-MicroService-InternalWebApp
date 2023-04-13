package com.decagon.DecagonOrganisationService.repository;

import com.decagon.DecagonOrganisationService.entity.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepository extends JpaRepository<Organisation, Long> {

}
