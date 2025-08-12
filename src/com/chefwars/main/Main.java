package com.chefwars.main;

import com.chefwars.entity.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SystemAdmin admin = new SystemAdmin("101","Dipesh","123@mail.com");


        Restaurant r1 = new Restaurant("Spice House");
        Restaurant r2 = new Restaurant("Tandoori Treats");


        Customer c1 = new Customer();


        DishComponent base1 = new BaseDish("Chicken Curry", 10.0);
        DishComponent custom1 = new ExtraCheese(new SpicySauce(base1)); // Decorated

        DishComponent base2 = new BaseDish("Paneer Tikka", 8.0);
        DishComponent custom2 = new DoubleChicken(base2); // Decorated


        Order order1 = new Order(c1, r1, new Flat10PercentOff());
        order1.addDish(custom1);
        order1.addDish(custom2);
        order1.printBill();


        c1.rateDish("Chicken Curry", 5);
        c1.rateDish("Paneer Tikka", 4);


        r1.recordRating("Chicken Curry", 5);
        r1.recordRating("Paneer Tikka", 4);


        Restaurant r3 = new Restaurant("Grill Master");
        DishComponent d3 = new BaseDish("Chicken Curry", 11.0);
        r3.recordRevenue(11.0, List.of(d3));
        r3.recordRating("Chicken Curry", 5);


        admin.top3Dishes(List.of(r1, r2, r3));
        admin.highestRevenueRestaurant(List.of(r1, r2, r3));
        admin.highestRatedDish(List.of(r1, r2, r3));
    }
}
