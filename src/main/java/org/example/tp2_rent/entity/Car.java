package org.example.tp2_rent.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Car extends Rental {
    private final String model;
    private final int placeNumber;

    public Car(String id, double price, String model, int placeNumber) {
        super(id, price);
        this.model = model;
        this.placeNumber = placeNumber;
    }
}
