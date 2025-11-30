package org.example.tp2_rent.controller;

import org.example.tp2_rent.entity.Association;
import org.example.tp2_rent.entity.Bicycle;
import org.example.tp2_rent.service.BicycleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BicycleController {
    private final BicycleService bicycleService =  new BicycleService();

    @GetMapping("/bicycles")
    public List<Bicycle> getAllBicycles() {
        return bicycleService.getAllBicycles(1, 10);
    }

    @GetMapping("/bicycles/{id}")
    public Bicycle getBicycle(@PathVariable String id) {
        return bicycleService.getBicycleById(id);
    }
}
