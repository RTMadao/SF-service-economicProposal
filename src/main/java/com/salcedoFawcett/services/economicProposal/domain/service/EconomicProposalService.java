package com.salcedoFawcett.services.economicProposal.domain.service;

import com.salcedoFawcett.services.economicProposal.client.EmailClient;
import com.salcedoFawcett.services.economicProposal.persistence.entity.EconomicProposal;
import com.salcedoFawcett.services.economicProposal.persistence.repository.EconomicProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EconomicProposalService {
    @Autowired
    private EconomicProposalRepository repository;
    @Autowired
    private EmailClient emailClient;

    public List<EconomicProposal> getAll() {
        return repository.getAll();
    }
    public Optional<EconomicProposal> getById(int id) {
        return repository.getById(id);
    }
    public EconomicProposal save(EconomicProposal economicProposal){
        return repository.save(economicProposal);
    }
    public Optional<EconomicProposal> update(EconomicProposal economicProposal){
        if (repository.exist(economicProposal.getId())) return Optional.of(repository.save(economicProposal));
        else return Optional.empty();
    }
    public boolean sendEconomicProposal(int id){
        return repository.getById(id).map(proposal -> {
            if (emailClient.sendEconomicProposalEmail(proposal).getStatusCode().is2xxSuccessful()) return true;
            else return false;
        }).orElse(false);
    }
    public boolean delete(int id){
        if (repository.exist(id)) {
            repository.delete(id);
            return true;
        } else return false;
    }
}
