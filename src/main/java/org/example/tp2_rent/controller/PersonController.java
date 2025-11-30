package org.example.tp2_rent.controller;

import org.example.tp2_rent.entity.Person;
import org.example.tp2_rent.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    private final PersonService personService =  new PersonService();

    @GetMapping("/persons")
    public List<Person> getAllCars() {
        return personService.getAll(1, 10);
    }

    @GetMapping("/persons/{id}")
    public Person getPersonById(@PathVariable String id) {
        return personService.getById(id);
    }
}
