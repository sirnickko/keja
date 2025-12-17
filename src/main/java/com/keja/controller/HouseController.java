package com.keja.controller;

import com.keja.dto.HouseWithLandlordDTO;
import com.keja.model.House;
import com.keja.model.Inquiry;
import com.keja.model.Landlord;
import com.keja.model.Tenant;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/houses")
public class HouseController {

    private final List<House> houses = new ArrayList<>();
    private final List<Inquiry> inquiries = new ArrayList<>(); // store inquiries

    private final LandlordController landlordController;
    private final TenantController tenantController;

    // Inject both controllers
    public HouseController(LandlordController landlordController, TenantController tenantController) {
        this.landlordController = landlordController;
        this.tenantController = tenantController;
    }

    @PostMapping("/add")
    public String addHouse(@RequestBody House house) {
        // Check if landlord exists
        boolean landlordExists = landlordController.getAllLandlords()
                .stream()
                .anyMatch(l -> l.getId() == house.getLandlordId());

        if (!landlordExists) {
            return "Error: Landlord with ID " + house.getLandlordId() + " not found!";
        }

        houses.add(house);
        return "House added at " + house.getLocation() + " by landlord ID " + house.getLandlordId();
    }

    @GetMapping("/search")
    public List<HouseWithLandlordDTO> searchHouses(@RequestParam String location, @RequestParam double maxPrice) {
        List<HouseWithLandlordDTO> results = new ArrayList<>();
        for (House house : houses) {
            if (house.getLocation().equalsIgnoreCase(location)
                    && house.getPrice() <= maxPrice
                    && house.isAvailable()) {

                // Fetch landlord info
                Landlord landlord = landlordController.getLandlordById(house.getLandlordId());
                if (landlord != null) {
                    results.add(new HouseWithLandlordDTO(
                            house.getLocation(),
                            house.getPrice(),
                            house.isAvailable(),
                            landlord.getName(),
                            landlord.getPhone(),
                            landlord.getEmail()
                    ));
                }
            }
        }
        return results;
    }

    @PostMapping("/{houseId}/contact")
    public String contactLandlord(@PathVariable int houseId,
                                  @RequestParam long tenantId,
                                  @RequestParam(required = false, defaultValue = "I am interested in this house.") String message) {
        // Find house
        if (houseId < 0 || houseId >= houses.size()) {
            return "Error: House not found!";
        }
        House house = houses.get(houseId);

        // Find landlord
        Landlord landlord = landlordController.getLandlordById(house.getLandlordId());
        if (landlord == null) {
            return "Error: Landlord not found!";
        }

        // Find tenant
        Tenant tenant = tenantController.getTenantById(tenantId);
        if (tenant == null) {
            return "Error: Tenant not found!";
        }

        // Save inquiry
        Inquiry inquiry = new Inquiry(tenantId, landlord.getId(), house.getLocation(), house.getPrice(), message);
        inquiries.add(inquiry);

        return "Inquiry sent! Tenant " + tenant.getName() + " (" + tenant.getPhone() +
                ") is interested in your house at " + house.getLocation() +
                ". Landlord: " + landlord.getName() + " (" + landlord.getPhone() + ")";
    }

    @GetMapping("/inquiries/{landlordId}")
    public List<Inquiry> getInquiriesForLandlord(@PathVariable long landlordId) {
        List<Inquiry> landlordInquiries = new ArrayList<>();
        for (Inquiry inquiry : inquiries) {
            if (inquiry.getLandlordId() == landlordId) {
                landlordInquiries.add(inquiry);
            }
        }
        return landlordInquiries;
    }
}
