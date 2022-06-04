package com.salcedoFawcett.services.economicProposal.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "service_catalogue")
public class ServiceCatalogue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String serviceName;

    public ServiceCatalogue(){}
    public ServiceCatalogue(String id, String serviceName) {
        this.id = id;
        this.serviceName = serviceName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
