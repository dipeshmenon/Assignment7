package com.chefwars.entity;
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
}
