package org.example.tp2_rent.entity;

import lombok.Getter;

@Getter
public class Money extends Rental{
    private final String device;

    public Money(String id, double price, String device) {
        super(id, price);
        this.device = device;
    }
}
