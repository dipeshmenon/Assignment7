package com.chefwars.entity;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SystemAdmin extends User {

    public SystemAdmin(String userId, String name, String email) {
        super(userId, name, email);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: System Admin");
    }

    public void blockRestaurant(String restaurantId) {
        System.out.println("Blocked restaurant with ID: " + restaurantId);
    }

    public void unblockRestaurant(String restaurantId) {
        System.out.println("Unblocked restaurant with ID: " + restaurantId);
    }

    public void viewAnalytics() {
        System.out.println("Viewing analytics: total revenue, most popular dishes, etc.");
    }
    public void highestRevenueRestaurant(List<Restaurant> restaurants) {
        Restaurant top = restaurants.stream()
                .max(Comparator.comparingDouble(Restaurant::getTotalRevenue))
                .orElse(null);
        if (top != null) {
            System.out.println("Top Revenue Restaurant: " + top.getName() + " - $" + String.format("%.2f", top.getTotalRevenue()));
        }
    }
    public void top3Dishes(List<Restaurant> restaurants) {
        Map<String, Integer> dishCounts = new HashMap<>();

        for (Restaurant r : restaurants) {
            for (Map.Entry<String, Integer> entry : r.getDishOrders().entrySet()) {
                dishCounts.put(entry.getKey(), dishCounts.getOrDefault(entry.getKey(), 0) + entry.getValue());
            }
        }

        System.out.println("Top 3 Most Ordered Dishes:");
        dishCounts.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(3)
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue() + " orders"));
    }

    public void highestRatedDish(List<Restaurant> restaurants) {
        String topDish = null;
        double highestAvg = 0.0;
        String restaurantName = null;

        for (Restaurant r : restaurants) {
            for (Map.Entry<String, List<Integer>> entry : r.getAllRatings().entrySet()) {
                double avg = entry.getValue().stream().mapToInt(i -> i).average().orElse(0);
                if (avg > highestAvg) {
                    highestAvg = avg;
                    topDish = entry.getKey();
                    restaurantName = r.getName();
                }
            }
        }

        if (topDish != null) {
            System.out.println("Top Rated Dish: " + topDish + " (Avg Rating: " + String.format("%.2f", highestAvg) + ") from " + restaurantName);
        } else {
            System.out.println("No dish ratings available.");
        }
    }
}


