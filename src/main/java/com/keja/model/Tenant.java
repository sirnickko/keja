package com.keja.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tenants")
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phone;

    private String email;

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inquiry> inquiries;

    // Constructors
    public Tenant() {}

    public Tenant(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Inquiry> getInquiries() {
        return inquiries;
    }

    public void setInquiries(List<Inquiry> inquiries) {
        this.inquiries = inquiries;
    }

    public void setId(long andIncrement) {
    }
}