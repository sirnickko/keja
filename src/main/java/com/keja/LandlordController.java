package com.keja;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/landlords")
public class LandlordController {

    private final List<Landlord> landlords = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @PostMapping("/register")
    public Landlord registerLandlord(@RequestBody Landlord landlord) {
        landlord.setId(idCounter.getAndIncrement()); // auto-generate ID
        landlords.add(landlord);
        return landlord;
    }

    @GetMapping
    public List<Landlord> getAllLandlords() {
        return landlords;
    }

    @GetMapping("/{id}")
    public Landlord getLandlordById(@PathVariable long id) {
        return landlords.stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
