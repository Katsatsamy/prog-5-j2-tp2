package org.example.tp2_rent.service;

import org.example.tp2_rent.Manager.PersonManger;
import org.example.tp2_rent.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonManger personManger =  new PersonManger();

    public List<Person> getAll(int page, int size) {
        return personManger.getAll(page, size);
    }

    public Person getById(String id) {
        return personManger.getById(id);
    }
}
