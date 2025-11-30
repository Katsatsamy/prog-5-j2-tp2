package org.example.tp2_rent.entity;

import lombok.Setter;

@Setter
public class Association extends Person{
    public Association(String id, String name, String email) {
        super(id, name, email);
    }
}
