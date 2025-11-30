package org.example.tp2_rent.controller;

import org.example.tp2_rent.entity.Pc;
import org.example.tp2_rent.service.PcService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PcController {
    private final PcService pcService =  new PcService();

    @GetMapping("/pcs")
    public List<Pc> getAllPcs() {
        return pcService.getAllPc(1, 10);
    }

    @GetMapping("/pcs/{id}")
    public Pc getCar(@PathVariable String id) {
        return pcService.getPcById(id);
    }
}
