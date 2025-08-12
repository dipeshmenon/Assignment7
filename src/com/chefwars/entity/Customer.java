package com.chefwars.entity;

public class Customer extends User {
    public Customer(String userId, String name, String email) {
        super(userId, name, email);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Customer");
    }

    public void browseRestaurants() {
        System.out.println(name + " is browsing restaurants.");
    }

    public void viewMenu(String restaurantId) {
        System.out.println(name + " is viewing menu of restaurant " + restaurantId);
    }

    public void placeOrder(String dish) {
        System.out.println(name + " placed an order for: " + dish);
    }

    public void customizeDish(String dish, String customization) {
        System.out.println(name + " customized " + dish + " with: " + customization);
    }

    public void viewOrderHistory() {
        System.out.println(name + " is viewing order history.");
    }
}

