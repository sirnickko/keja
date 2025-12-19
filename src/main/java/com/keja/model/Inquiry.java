package com.keja.model;

import jakarta.persistence.*;

@Entity
@Table(name = "inquiries")
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @ManyToOne
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;

    @ManyToOne
    @JoinColumn(name = "house_id", nullable = false)
    private House house;

    // Constructors
    public Inquiry() {}

    public Inquiry(String message, Tenant tenant, House house) {
        this.message = message;
        this.tenant = tenant;
        this.house = house;
    }

    public Inquiry(long tenantId, Long id, String location, double price, String message) {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    // Optional helper
    public Long getLandlordId() {
        return house != null && house.getLandlord() != null ? house.getLandlord().getId() : null;
    }
}