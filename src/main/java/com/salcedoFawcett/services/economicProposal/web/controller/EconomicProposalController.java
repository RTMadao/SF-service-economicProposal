package com.salcedoFawcett.services.economicProposal.web.controller;

import com.salcedoFawcett.services.economicProposal.domain.service.EconomicProposalService;
import com.salcedoFawcett.services.economicProposal.persistence.entity.EconomicProposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/economical_proposal")
public class EconomicProposalController {
    @Autowired
    private EconomicProposalService service;

    @GetMapping("/all")
    public ResponseEntity<List<EconomicProposal>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<EconomicProposal> getEconomicProposalById(@PathVariable("id") int id) {
        return service.getById(id)
                .map( item -> new ResponseEntity<>(item, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/send/{id}")
    public  ResponseEntity sendEconomicProposal(@PathVariable("id") int id) {
        if (service.sendEconomicProposal(id)) return new ResponseEntity<>(HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<EconomicProposal> saveEconomicProposal(@RequestBody EconomicProposal proposal){
        return new ResponseEntity<>(service.save(proposal), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public  ResponseEntity<EconomicProposal> updateBasicInfo(@RequestBody EconomicProposal proposal) {
        return  service.update(proposal).map(proposalUpdates -> new ResponseEntity<>(proposalUpdates,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("delete/{id}")
    public  ResponseEntity delete(@PathVariable("id") int id) {
        if (service.delete(id)) return new ResponseEntity<>(HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
