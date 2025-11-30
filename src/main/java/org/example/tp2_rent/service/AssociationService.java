package org.example.tp2_rent.service;

import org.example.tp2_rent.Manager.AssociationManager;
import org.example.tp2_rent.entity.Association;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociationService {
    private AssociationManager associationManager = new AssociationManager();

    public List<Association> getAll(int page, int size) {
        return associationManager.getAll(page, size);
    }
    public Association getById(String id) {
        return associationManager.getById(id);
    }
}
