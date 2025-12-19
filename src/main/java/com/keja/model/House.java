package com.keja.model;

import jakarta.persistence.*;

@Entity
@Table(name = "houses")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;

    private double price;

    private boolean available;

    @ManyToOne
    @JoinColumn(name = "landlord_id", nullable = false)
    private Landlord landlord;

    // Constructors
    public House() {}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    // Optional helper method
    public Long getLandlordId() {
        return landlord != null ? landlord.getId() : null;
    }
}
