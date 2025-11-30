package org.example.tp2_rent.controller;

import org.example.tp2_rent.entity.Car;
import org.example.tp2_rent.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {
    private final CarService carService =  new CarService();

    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return carService.getAllCars(1, 10);
    }

    @GetMapping("/cars/{id}")
    public Car getCar(@PathVariable String id) {
        return carService.getCarById(id);
    }
}
