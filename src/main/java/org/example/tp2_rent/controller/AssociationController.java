package org.example.tp2_rent.controller;

import org.example.tp2_rent.entity.Association;
import org.example.tp2_rent.service.AssociationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AssociationController {
    private final AssociationService associationService =  new AssociationService();

    @GetMapping("/bicycle")
    public List<Association> getAllAssociations() {
        return associationService.getAll(1, 10);
    }

    @GetMapping("/bicycle/{id}")
    public Association getAssociation(@PathVariable String id) {
        return associationService.getById(id);
    }
    
}
