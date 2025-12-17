package com.keja.model;

public class Inquiry {
    private long tenantId;
    private long landlordId;
    private String houseLocation;
    private double housePrice;
    private String message;

    public Inquiry(long tenantId, long landlordId, String houseLocation, double housePrice, String message) {
        this.tenantId = tenantId;
        this.landlordId = landlordId;
        this.houseLocation = houseLocation;
        this.housePrice = housePrice;
        this.message = message;
    }

    // Getters
    public long getTenantId() { return tenantId; }
    public long getLandlordId() { return landlordId; }
    public String getHouseLocation() { return houseLocation; }
    public double getHousePrice() { return housePrice; }
    public String getMessage() { return message; }
}
