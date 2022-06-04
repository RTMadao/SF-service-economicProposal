package com.salcedoFawcett.services.economicProposal.persistence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "economic_proposal")
public class EconomicProposal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int customerId;
    private int customerContactId;
    private String description;
    private String priceValue;
    private String paymentMethod;
    private String terms;
    private String workforce;
    private String deliverables;
    private String note;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state", referencedColumnName = "id")
    private State state;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "economic_proposal_service_catalogue",
            joinColumns = @JoinColumn(name = "economic_proposal_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private Set<ServiceCatalogue> services;

    public EconomicProposal(){}
    public EconomicProposal(int id, int customerId, int customerContactId, String description, String priceValue, String paymentMethod, String terms, String workforce, String deliverables, String note, State state, Set<ServiceCatalogue> services) {
        this.id = id;
        this.customerId = customerId;
        this.customerContactId = customerContactId;
        this.description = description;
        this.priceValue = priceValue;
        this.paymentMethod = paymentMethod;
        this.terms = terms;
        this.workforce = workforce;
        this.deliverables = deliverables;
        this.note = note;
        this.state = state;
        this.services = services;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerContactId() {
        return customerContactId;
    }

    public void setCustomerContactId(int customerContactId) {
        this.customerContactId = customerContactId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(String priceValue) {
        this.priceValue = priceValue;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getWorkforce() {
        return workforce;
    }

    public void setWorkforce(String workforce) {
        this.workforce = workforce;
    }

    public String getDeliverables() {
        return deliverables;
    }

    public void setDeliverables(String deliverables) {
        this.deliverables = deliverables;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Set<ServiceCatalogue> getServices() {
        return services;
    }

    public void setServices(Set<ServiceCatalogue> services) {
        this.services = services;
    }
}
