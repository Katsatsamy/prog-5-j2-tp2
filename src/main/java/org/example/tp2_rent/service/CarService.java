package org.example.tp2_rent.service;

import org.example.tp2_rent.Manager.CarManger;
import org.example.tp2_rent.entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private  final CarManger carManger =  new CarManger();

    public List<Car> getAllCars(int page, int size){
        return carManger.getAll(page,size);
    }

    public Car getCarById(String id){
        return carManger.getById(id);
    }
}
