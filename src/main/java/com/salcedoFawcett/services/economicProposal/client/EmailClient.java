package com.salcedoFawcett.services.economicProposal.client;

import com.salcedoFawcett.services.economicProposal.persistence.entity.EconomicProposal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("email-service")
public interface EmailClient {
    @PostMapping("/email/send/economical_proposal/to_client")
    public ResponseEntity sendEconomicProposalEmail(@RequestBody EconomicProposal proposal);
}
