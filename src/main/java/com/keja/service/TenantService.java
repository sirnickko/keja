package com.keja.service;

import com.keja.model.Tenant;
import java.util.List;

public interface TenantService {

    Tenant saveTenant(Tenant tenant);

    List<Tenant> getAllTenants();

    Tenant getTenantById(Long id);
}
