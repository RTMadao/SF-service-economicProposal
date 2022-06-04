package com.salcedoFawcett.services.economicProposal.persistence.crud;

import com.salcedoFawcett.services.economicProposal.persistence.entity.EconomicProposal;
import org.springframework.data.repository.CrudRepository;

public interface EconomicProposalCrudRepository extends CrudRepository<EconomicProposal, Integer> {
}
