package com.Joakim.boxinator.api.box.controller.dto;

public class BoxResponseDto {

    private String name;

    private double weight;

    private String color;

    private String country;

    private double shippingCost;

    public BoxResponseDto() {
    }

    public BoxResponseDto(String name, double weight, String color, String country, double shippingCost) {
        this.name = name;
        this.weight = weight;
        this.color = color;
        this.country = country;
        this.shippingCost = shippingCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }
}
