package com.salcedoFawcett.services.economicProposal.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "economic_proposal_state")
public class State {
    @Id
    private int id;
    private String name;

    public State(){}
    public State(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
