package com.chefwars.entity;

public class ExtraCheese extends DishDecorator {
    public ExtraCheese(DishComponent dish) {
        super(dish);
    }

    @Override
    public String getDescription() {
        return dish.getDescription() + ", Extra Cheese";
    }

    @Override
    public double getPrice() {
        return dish.getPrice() + 1.50;
    }
}

