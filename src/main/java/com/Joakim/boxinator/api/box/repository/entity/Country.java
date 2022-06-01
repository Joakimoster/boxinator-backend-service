package com.Joakim.boxinator.api.box.repository.entity;

public enum Country {
    SWEDEN(1.3),
    CHINA(4),
    BRAZIL(8.6),
    AUSTRALIA(7.2);

    private final double multiplier;

    Country(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }
}
