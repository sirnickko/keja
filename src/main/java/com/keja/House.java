package com.keja;

public class House {
    private String location;
    private double price;
    private boolean available;
    private long landlordId; // new field

    // Getters and Setters
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public long getLandlordId() { return landlordId; }
    public void setLandlordId(long landlordId) { this.landlordId = landlordId; }
}
