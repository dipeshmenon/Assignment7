package com.chefwars.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer extends User {
    public Customer(String userId, String name, String email) {
        super(userId, name, email);
    }
    private String name;
    private List<Order> orderHistory = new ArrayList<>();
    private Map<String, List<Integer>> ratings = new HashMap<>();

    public Customer() {
        super();
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

    public void addOrder(Order order) {
        orderHistory.add(order);
    }

    public void rateDish(String dishName, int stars) {
        ratings.computeIfAbsent(dishName, k -> new ArrayList<>()).add(stars);
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public Map<String, List<Integer>> getRatings() {
        return ratings;
    }

}

