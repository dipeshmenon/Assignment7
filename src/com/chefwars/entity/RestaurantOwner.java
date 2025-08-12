package com.chefwars.entity;

public class RestaurantOwner extends User {
    private String restaurantId;

    public RestaurantOwner(String userId, String name, String email, String restaurantId) {
        super(userId, name, email);
        this.restaurantId = restaurantId;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Restaurant Owner");
    }

    public void addDish(String dishName, double price) {
        System.out.println("Added dish: " + dishName + " at price $" + price);
    }

    public void changeDishPrice(String dishName, double newPrice) {
        System.out.println("Changed price of " + dishName + " to $" + newPrice);
    }

    public void runOffer(String offerDetails) {
        System.out.println("Running offer: " + offerDetails);
    }

    public void trackCompetitorPrices() {
        System.out.println("Tracking competitor restaurant prices...");
    }
}

