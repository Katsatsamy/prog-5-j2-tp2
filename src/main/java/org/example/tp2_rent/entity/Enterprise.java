package org.example.tp2_rent.entity;

import lombok.Getter;

@Getter
public class Enterprise extends Person implements Renter {

    public Enterprise(String id, String name, String email) {
        super(id, name, email);
    }
}

