package com.keja.service;

import com.keja.model.House;
import java.util.List;

public interface HouseService {

    House saveHouse(House house);

    List<House> getAllHouses();

    List<House> getAvailableHouses();
}
