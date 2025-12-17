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
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;

    public Inquiry(long tenantId, Long id, String location, double price, String message) {
    }

    public long getLandlordId() {
        return 0;
    }
}
