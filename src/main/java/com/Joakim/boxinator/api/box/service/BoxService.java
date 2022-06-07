package com.Joakim.boxinator.api.box.service;

import com.Joakim.boxinator.api.box.controller.dto.BoxResponseDto;
import com.Joakim.boxinator.api.box.repository.BoxRepository;
import com.Joakim.boxinator.api.box.repository.entity.Box;
import com.Joakim.boxinator.api.box.repository.entity.Country;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoxService implements IBoxService {

    private final BoxRepository repository;

    public BoxService(BoxRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BoxResponseDto> getAllBoxes() {
        return repository.getAllBoxes();
    }

    @Override
    public Box addBox(Box box) {
        double weight = box.getWeight();
        String country = box.getCountry();
        double shippingCost = calculateShippingCost(weight, country);
        box.setShippingCost(shippingCost);
        return repository.addBox(box);
    }

    //TODO: Implement error handling (only capital letters working in postman
    public double calculateShippingCost(double weight, String country) {
        switch (country) {
            case "SWEDEN":
                return weight * Country.SWEDEN.getMultiplier();
            case "CHINA":
                return weight * Country.CHINA.getMultiplier();
            case "BRAZIL":
                return weight * Country.BRAZIL.getMultiplier();
            case "AUSTRALIA":
                return weight * Country.AUSTRALIA.getMultiplier();
        } return 0;
    }
}
