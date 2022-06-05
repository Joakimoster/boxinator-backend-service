package com.Joakim.boxinator.api.box.controller.dto;

public class BoxDto {

    private String name;

    private double weight;

    private String color;

    private double shippingCost;

    public BoxDto() {
    }

    public BoxDto(String name, double weight, String color, double shippingCost) {
        this.name = name;
        this.weight = weight;
        this.color = color;
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

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }
}
