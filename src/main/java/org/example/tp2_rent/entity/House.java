package org.example.tp2_rent.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class House extends Rental{
    private final String color;

    public House(String id, double price, String color) {
        super(id, price);
        this.color = color;
    }
}
