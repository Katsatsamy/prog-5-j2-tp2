package org.example.tp2_rent.service;

import org.example.tp2_rent.Manager.BicycleManger;
import org.example.tp2_rent.entity.Association;
import org.example.tp2_rent.entity.Bicycle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BicycleService {
    private final BicycleManger  bicycleManger = new BicycleManger();

    public List<Bicycle> getAllBicycles(int page, int size) {
        return bicycleManger.getAll(page, size);
    }

    public Bicycle getBicycleById(String id) {
        return bicycleManger.getById(id);
    }

}
