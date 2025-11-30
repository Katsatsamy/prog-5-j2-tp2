package org.example.tp2_rent.controller;

import org.example.tp2_rent.entity.Money;
import org.example.tp2_rent.service.MoneyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoneyController {
    private final MoneyService moneyService =  new MoneyService();

    @GetMapping("/moneys")
    public List<Money> getAllMoneys() {
        return moneyService.getAllMoneys(1, 10);
    }

    @GetMapping("/moneys/{id}")
    public Money getMoneyById(@PathVariable String id) {
        return moneyService.getMoneyById(id);
    }
}
