package com.chefwars.entity;

import java.util.*;

public class PriceWarManager {
    private List<Restaurant> restaurants = new ArrayList<>();

    public void registerRestaurant(Restaurant restaurant) {
        if (restaurant.getMenuSize() >= 5) {
            restaurants.add(restaurant);
            System.out.println("Registered: " + restaurant.getName());
        } else {
            System.out.println("Restaurant '" + restaurant.getName() + "' rejected (minimum 5 dishes required).");
        }
    }

    public void notifyRestaurants(String dishName, Restaurant initiator) {
        for (Restaurant restaurant : restaurants) {
            if (!restaurant.equals(initiator)) {
                restaurant.onPriceWar(dishName);
            }
        }
    }
}
