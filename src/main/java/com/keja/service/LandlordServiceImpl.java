package com.keja.service;

import com.keja.model.Landlord;
import com.keja.repository.LandlordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandlordServiceImpl implements LandlordService {

    private final LandlordRepository landlordRepository;

    public LandlordServiceImpl(LandlordRepository landlordRepository) {
        this.landlordRepository = landlordRepository;
    }

    @Override
    public Landlord saveLandlord(Landlord landlord) {
        return landlordRepository.save(landlord);
    }

    @Override
    public List<Landlord> getAllLandlords() {
        return landlordRepository.findAll();
    }

    @Override
    public Landlord getLandlordById(Long id) {
        return landlordRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteLandlord(Long id) {
        landlordRepository.deleteById(id);
    }
}
