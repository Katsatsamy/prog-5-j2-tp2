package org.example.tp2_rent.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Person implements Renter {
    private String id;
    private String name;
    private String email;

    @Override
    public boolean rent(Rental rental) {
        return true;
    }
}
