package org.example.tp2_rent.service;

import org.example.tp2_rent.Manager.PcManager;
import org.example.tp2_rent.entity.Pc;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PcService {
    private final PcManager pcManager = new PcManager();

    public List<Pc> getAllPc(int page, int size){
        return pcManager.getAll(page, size);
    }

    public Pc getPcById(String id){
        return pcManager.getById(id);
    }
}
