package com.chefwars.entity;

public abstract class DishDecorator implements DishComponent {
    protected DishComponent dish;

    public DishDecorator(DishComponent dish) {
        this.dish = dish;
    }

    @Override
    public String getDescription() {
        return dish.getDescription();
    }

    @Override
    public double getPrice() {
        return dish.getPrice();
    }
}
