package org.example.tp2_rent.entity;

import lombok.Getter;

@Getter
public class Pc extends Rental{
    private final String model;
    private final String brand;

    public Pc(String id, double price, String model, String brand) {
        super(id, price);
        this.model = model;
        this.brand = brand;
    }
}
