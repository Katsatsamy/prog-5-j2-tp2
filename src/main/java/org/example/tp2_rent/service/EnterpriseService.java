package org.example.tp2_rent.service;

import org.example.tp2_rent.Manager.EnterpriseManger;
import org.example.tp2_rent.entity.Enterprise;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService {
    private final EnterpriseManger enterpriseManger =  new EnterpriseManger();

    public List<Enterprise> getAllEnterprise(int page, int size){
        return enterpriseManger.getAll(page, size);
    }

    public Enterprise getEnterpriseById(String id){
        return enterpriseManger.getById(id);
    }
}
