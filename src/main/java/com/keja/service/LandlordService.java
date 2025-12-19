package com.keja.service;

import com.keja.model.Landlord;
import java.util.List;

public interface LandlordService {

    Landlord saveLandlord(Landlord landlord);

    List<Landlord> getAllLandlords();

    Landlord getLandlordById(Long id);

    void deleteLandlord(Long id);
}
