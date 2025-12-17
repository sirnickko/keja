package com.keja.repository;

import com.keja.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseRepository extends JpaRepository<House, Long> {

    // Custom query methods (optional but useful)
    List<House> findByAvailableTrue();

    List<House> findByLocation(String location);
}

