package org.roshan.lab11_roshan;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Order {

    private final Map<String, Double> entreePrices = new LinkedHashMap<>();
    private final Map<String, Double> drinkPrices = new LinkedHashMap<>();

    private String entree;
    private String drink;
    private String specialRequests = "";
    private boolean water = false;

    public Order() {
        entreePrices.put("Chicken Salad", 6.50);
        entreePrices.put("Turkey Sandwich", 6.75);
        entreePrices.put("Vegetable Wrap", 6.00);
        entreePrices.put("Grilled Cheese", 5.00);

        drinkPrices.put("Coffee", 1.50);
        drinkPrices.put("Tea", 1.50);
        drinkPrices.put("Soda", 2.00);
        drinkPrices.put("Juice", 1.75);
    }
}