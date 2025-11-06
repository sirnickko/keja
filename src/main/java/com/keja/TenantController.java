package com.keja;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/tenants")
public class TenantController {

    private final List<Tenant> tenants = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @PostMapping("/register")
    public Tenant registerTenant(@RequestBody Tenant tenant) {
        tenant.setId(idCounter.getAndIncrement());
        tenants.add(tenant);
        return tenant;
    }

    @GetMapping
    public List<Tenant> getAllTenants() {
        return tenants;
    }

    @GetMapping("/{id}")
    public Tenant getTenantById(@PathVariable long id) {
        return tenants.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
