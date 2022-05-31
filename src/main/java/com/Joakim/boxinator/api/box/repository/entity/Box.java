package com.Joakim.boxinator.api.box.repository.entity;

public class Box {

    private Long id;

    private String name;

    private int weight; //Could be double as data type.

    private String country; //Could be implemented as an Enum.

    private int shippingCost; //Could be double as data type.

    public Box() {
    }

    public Box(Long id, String name, int weight, String country, int shippingCost) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.country = country;
        this.shippingCost = shippingCost;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(int shippingCost) {
        this.shippingCost = shippingCost;
    }
}
