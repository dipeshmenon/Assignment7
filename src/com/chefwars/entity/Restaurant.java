package com.chefwars.entity;

import java.util.*;

public class Restaurant implements RestaurantObserver {
    private String name;
    private Map<String, Dish> menu = new HashMap<>();
    private PriceWarManager manager;

    public Restaurant(String name, PriceWarManager manager) {
        this.name = name;
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void addDish(String name, double price) {
        menu.put(name, new Dish(name, price));
    }

    public int getMenuSize() {
        return menu.size();
    }

    public void register() {
        manager.registerRestaurant(this);
    }

    public void reduceDishPrice(String dishName, double newPrice) {
        Dish dish = menu.get(dishName);
        if (dish != null) {
            double originalPrice = dish.getPrice();
            double percentageDrop = ((originalPrice - newPrice) / originalPrice) * 100;

            dish.setPrice(newPrice);
            System.out.println(this.name + " reduced " + dishName + " to $" + newPrice + " (" + String.format("%.2f", percentageDrop) + "%)");

            if (percentageDrop > 15.0) {
                manager.notifyRestaurants(dishName, this);
            }
        } else {
            System.out.println(dishName + " not found in " + name + "'s menu.");
        }
    }

    @Override
    public void onPriceWar(String dishName) {
        Dish dish = menu.get(dishName);
        if (dish != null) {
            double oldPrice = dish.getPrice();
            double newPrice = oldPrice - (oldPrice * 0.05);
            dish.setPrice(newPrice);
            System.out.println(this.name + " adjusted price of " + dishName + " to $" + String.format("%.2f", newPrice) + " (5% drop)");
        }
    }

    public void printMenu() {
        System.out.println("Menu for " + name + ":");
        for (Dish dish : menu.values()) {
            System.out.println("- " + dish.getName() + ": $" + String.format("%.2f", dish.getPrice()));
        }
    }
}
