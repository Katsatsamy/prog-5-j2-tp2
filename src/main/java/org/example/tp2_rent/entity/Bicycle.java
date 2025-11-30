package org.example.tp2_rent.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Bicycle extends Rental{
    private final String model;
    private final String brand;
    private final String color;

    public Bicycle(String id, double price, String model, String brand, String color) {
        super(id, price);
        this.model = model;
        this.brand = brand;
        this.color = color;
    }
}
