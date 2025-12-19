package com.keja.controller;

import com.keja.model.House;
import com.keja.model.Landlord;
import com.keja.service.HouseService;
import com.keja.service.LandlordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/houses")
public class HouseController {

    private final HouseService houseService;
    private final LandlordService landlordService;

    public HouseController(HouseService houseService, LandlordService landlordService) {
        this.houseService = houseService;
        this.landlordService = landlordService;
    }

    @PostMapping
    public House addHouse(@RequestParam Long landlordId, @RequestBody House house) {

        Landlord landlord = landlordService.getLandlordById(landlordId);
        if (landlord == null) {
            throw new RuntimeException("Landlord not found");
        }

        house.setLandlord(landlord);
        return houseService.saveHouse(house);
    }

    @GetMapping
    public List<House> getAllHouses() {
        return houseService.getAllHouses();
    }

    @GetMapping("/available")
    public List<House> getAvailableHouses() {
        return houseService.getAvailableHouses();
    }
}

