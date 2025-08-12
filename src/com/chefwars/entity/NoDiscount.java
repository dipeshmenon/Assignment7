package com.chefwars.entity;

public class NoDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        return total;
    }
}

class FlatAmountOff implements DiscountStrategy {
    private double amount;

    public FlatAmountOff(double amount) {
        this.amount = amount;
    }

    @Override
    public double applyDiscount(double total) {
        return Math.max(0, total - amount);
    }
}

