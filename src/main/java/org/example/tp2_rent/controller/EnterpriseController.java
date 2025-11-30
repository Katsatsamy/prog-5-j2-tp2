package org.example.tp2_rent.controller;


import org.example.tp2_rent.entity.Enterprise;
import org.example.tp2_rent.service.EnterpriseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnterpriseController {
    private final EnterpriseService enterpriseService =  new EnterpriseService();

    @GetMapping("/enterprises")
    public List<Enterprise> getAllEnterprises() {
        return enterpriseService.getAllEnterprise(1, 10);
    }

    @GetMapping("/enterprises/{id}")
    public Enterprise getEnterprise(@PathVariable String id) {
        return enterpriseService.getEnterpriseById(id);
    }
}
