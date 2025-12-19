package com.keja.controller;

import com.keja.model.Tenant;
import com.keja.service.TenantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tenants")
public class TenantController {

    private final TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    // Register tenant
    @PostMapping
    public Tenant registerTenant(@RequestBody Tenant tenant) {
        return tenantService.saveTenant(tenant);
    }

    // Get all tenants
    @GetMapping
    public List<Tenant> getAllTenants() {
        return tenantService.getAllTenants();
    }

    // Get tenant by ID
    @GetMapping("/{id}")
    public Tenant getTenantById(@PathVariable Long id) {
        return tenantService.getTenantById(id);
    }
}

