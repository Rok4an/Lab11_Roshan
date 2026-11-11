package org.roshan.lab11_roshan;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Order {

    private final Map<String, Double> entreePrices = new LinkedHashMap<>();
    private final Map<String, Double> drinkPrices = new LinkedHashMap<>();

    @Getter @Setter private String entree;
    @Getter @Setter private String drink;
    @Getter @Setter private boolean water = false;
    @Getter private String specialRequests = "";

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

    public void setSpecialRequests(String specialRequests) {
        this.specialRequests = (specialRequests == null) ? "" : specialRequests;
    }

    public List<String> getEntreeNames() {
        return new ArrayList<>(entreePrices.keySet());
    }

    public double getEntreePrice() {
        if (entree == null) return 0.0;
        return entreePrices.get(entree);
    }

    public double getDrinkPrice() {
        if (drink == null) return 0.0;
        return drinkPrices.get(drink);
    }

    public double getTotal() {
        return getEntreePrice() + getDrinkPrice();
    }

    public boolean isComplete() {
        return entree != null && drink != null;
    }

    public void clearAll() {
        entree = null;
        drink = null;
        specialRequests = "";
        water = false;
    }
}