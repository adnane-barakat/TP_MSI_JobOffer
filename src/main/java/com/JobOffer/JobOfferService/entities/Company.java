package com.JobOffer.JobOfferService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Company {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;

    public Company() {}

    public Company(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public Long getId() {
        return id;
    }

    public String GetName() {
        return name;
    }
    public Company SetName(String name) {
        this.name = name;
        return this;
    }

    public String GetAddress() {
        return address;
    }
    public Company setAddress(String address) {
        this.address = address;
        return this;
    }


}
