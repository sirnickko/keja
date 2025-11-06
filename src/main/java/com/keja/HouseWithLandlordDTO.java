package com.keja;

public class HouseWithLandlordDTO {
    private String location;
    private double price;
    private boolean available;
    private String landlordName;
    private String landlordPhone;
    private String landlordEmail;

    public HouseWithLandlordDTO(String location, double price, boolean available,
                                String landlordName, String landlordPhone, String landlordEmail) {
        this.location = location;
        this.price = price;
        this.available = available;
        this.landlordName = landlordName;
        this.landlordPhone = landlordPhone;
        this.landlordEmail = landlordEmail;
    }

    // Getters
    public String getLocation() { return location; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return available; }
    public String getLandlordName() { return landlordName; }
    public String getLandlordPhone() { return landlordPhone; }
    public String getLandlordEmail() { return landlordEmail; }
}
