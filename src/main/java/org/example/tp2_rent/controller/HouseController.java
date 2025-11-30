package org.example.tp2_rent.controller;

import org.example.tp2_rent.entity.House;
import org.example.tp2_rent.service.HouseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HouseController {
    private final HouseService houseService =  new HouseService();

    @GetMapping("/houses")
    public List<House> getAllHouses() {
        return houseService.getAllHouses(1, 10);
    }

    @GetMapping("/houses/{id}")
    public House getHouseById(@PathVariable String id) {
        return houseService.getHouseById(id);
    }
}
