package com.chefwars.entity;

public class BaseDish implements DishComponent {
    private String name;
    private double basePrice;

    public BaseDish(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    @Override
    public String getDescription() {
        return name;
    }

    @Override
    public double getPrice() {
        return basePrice;
    }
}
