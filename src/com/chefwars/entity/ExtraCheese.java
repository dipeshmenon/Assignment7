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

 class DoubleChicken extends DishDecorator {
    public DoubleChicken(DishComponent dish) {
        super(dish);
    }

    @Override
    public String getDescription() {
        return dish.getDescription() + ", Double Chicken";
    }

    @Override
    public double getPrice() {
        return dish.getPrice() + 2.00;
    }
}

class SpicySauce extends DishDecorator {
    public SpicySauce(DishComponent dish) {
        super(dish);
    }

    @Override
    public String getDescription() {
        return dish.getDescription() + ", Spicy Sauce";
    }

    @Override
    public double getPrice() {
        return dish.getPrice() + 0.75;
    }
}

