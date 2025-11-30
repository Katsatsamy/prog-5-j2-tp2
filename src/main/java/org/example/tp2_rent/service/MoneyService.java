package org.example.tp2_rent.service;

import org.example.tp2_rent.Manager.MoneyManager;
import org.example.tp2_rent.entity.Money;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoneyService {
    private final MoneyManager moneyManager = new MoneyManager();

    public List<Money> getAllMoneys(int page, int size) {
        return moneyManager.getAll(page, size);
    }

    public Money getMoneyById(String id) {
        return moneyManager.getById(id);
    }
}
