package com.keja.service;

import com.keja.model.House;
import com.keja.repository.HouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    private final HouseRepository houseRepository;

    public HouseServiceImpl(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Override
    public House saveHouse(House house) {
        return houseRepository.save(house);
    }

    @Override
    public List<House> getAllHouses() {
        return houseRepository.findAll();
    }

    @Override
    public List<House> getAvailableHouses() {
        return houseRepository.findByAvailableTrue();
    }
}
