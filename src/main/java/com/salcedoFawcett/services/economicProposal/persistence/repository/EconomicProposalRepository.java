package com.salcedoFawcett.services.economicProposal.persistence.repository;

import com.salcedoFawcett.services.economicProposal.persistence.crud.EconomicProposalCrudRepository;
import com.salcedoFawcett.services.economicProposal.persistence.entity.EconomicProposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EconomicProposalRepository {
    @Autowired
    private EconomicProposalCrudRepository crudRepository;

    public List<EconomicProposal> getAll() {
        return (List<EconomicProposal>) crudRepository.findAll();
    }

    public Optional<EconomicProposal> getById(int id) {
        return crudRepository.findById(id);
    }

    public EconomicProposal save(EconomicProposal economicProposal) {
        return crudRepository.save(economicProposal);
    }

    public boolean exist(int id) {
        return crudRepository.existsById(id);
    }

    public void delete(int id) {
        crudRepository.deleteById(id);
    }
}
