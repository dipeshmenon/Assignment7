package com.chefwars.entity;

import java.util.*;

public class Order {
    private List<DishComponent> dishes = new ArrayList<>();
    private DiscountStrategy discountStrategy;
    private static final double GST = 0.05;
    private Customer customer;
    private Restaurant restaurant;

    public Order(Customer customer, Restaurant restaurant, DiscountStrategy discountStrategy) {
        this.customer = customer;
        this.restaurant = restaurant;
        this.discountStrategy = discountStrategy;
    }

    public void addDish(DishComponent dish) {
        dishes.add(dish);
    }

    public double calculateBasePrice() {
        return dishes.stream().mapToDouble(DishComponent::getPrice).sum();
    }

    public double calculateTax(double subtotal) {
        return subtotal * GST;
    }

    public double calculateTotal() {
        double subtotal = calculateBasePrice();
        double discounted = discountStrategy.applyDiscount(subtotal);
        return discounted + calculateTax(discounted);
    }

    public void printBill() {
        System.out.println("----- BILL -----");
        for (DishComponent dish : dishes) {
            System.out.println(dish.getDescription() + ": $" + String.format("%.2f", dish.getPrice()));
        }
        double base = calculateBasePrice();
        double discounted = discountStrategy.applyDiscount(base);
        double tax = calculateTax(discounted);
        double total = discounted + tax;

        System.out.println("Subtotal: $" + String.format("%.2f", base));
        System.out.println("After Discount: $" + String.format("%.2f", discounted));
        System.out.println("GST (5%): $" + String.format("%.2f", tax));
        System.out.println("Total: $" + String.format("%.2f", total));
        System.out.println("----------------");

        customer.addOrder(this);
        restaurant.recordRevenue(total, dishes);
    }

    public List<DishComponent> getDishes() {
        return dishes;
    }
}
