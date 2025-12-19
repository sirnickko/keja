package com.keja.controller;

import com.keja.model.Landlord;
import com.keja.service.LandlordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/landlords")
public class LandlordController {

    private final LandlordService landlordService;

    public LandlordController(LandlordService landlordService) {
        this.landlordService = landlordService;
    }

    // Register landlord
    @PostMapping
    public Landlord registerLandlord(@RequestBody Landlord landlord) {
        return landlordService.saveLandlord(landlord);
    }

    // Get all landlords
    @GetMapping
    public List<Landlord> getAllLandlords() {
        return landlordService.getAllLandlords();
    }

    // Get landlord by ID
    @GetMapping("/{id}")
    public Landlord getLandlordById(@PathVariable Long id) {
        return landlordService.getLandlordById(id);
    }

    // Delete landlord
    @DeleteMapping("/{id}")
    public void deleteLandlord(@PathVariable Long id) {
        landlordService.deleteLandlord(id);
    }
}
