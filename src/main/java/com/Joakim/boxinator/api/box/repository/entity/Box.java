package com.Joakim.boxinator.api.box.repository.entity;

public class Box {

    private Long id;

    private String name;

    private double weight;

    private String color;

    private double shippingCost;

    private String country;

    public Box() {
    }

    public Box(Long id, String name, double weight, String color, double shippingCost, String country) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.color = color;
        this.shippingCost = shippingCost;
        this.country = country;
    }

    public Box(String name, double weight, String color, double shippingCost, String country) {
        this.name = name;
        this.weight = weight;
        this.color = color;
        this.shippingCost = shippingCost;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
