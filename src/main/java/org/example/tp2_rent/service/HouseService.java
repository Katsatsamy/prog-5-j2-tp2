package org.example.tp2_rent.service;

import org.example.tp2_rent.Manager.HouseManager;
import org.example.tp2_rent.entity.House;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {
    private final HouseManager houseManager =  new HouseManager();

    public List<House> getAllHouses(int page, int size) {
        return houseManager.getAll(page, size);
    }

    public House getHouseById(String id) {
        return houseManager.getById(id);
    }
}
