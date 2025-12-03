package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a shopping cart that holds products and their quantities.
 * This class allows adding and removing products, and tracking the contents of the cart.
 * This class was created solely for educational purposes. The code is not optimized,
 * but is designed to allow students to practice and apply JUnit features.
 */
public class ShoppingCart {

    private final HashMap<String, Integer> items;

    public enum RemovalStatus {
        REMOVED,
        NOT_IN_CART,
        NOT_ENOUGH_ITEMS,
    }

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    /**
     * Adds a given quantity of a product to the cart.
     * If the product is already in the cart, its quantity is updated.
     *
     * @param product  The name of the product to add.
     * @param quantity The quantity of the product to add.
     * @throws IllegalArgumentException If the product name is null, empty, or if the quantity is less than or equal to zero.
     */
    public void addItem(String product, int quantity) {
        if (product == null || product.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        String normalizedProduct = product.toLowerCase().trim();
        items.put(normalizedProduct, items.getOrDefault(normalizedProduct, 0) + quantity);
    }

    /**
     * Attempts to remove a specified quantity of a product from the cart.
     *
     * @param product  The name of the product to remove.
     * @param quantity The quantity of the product to remove.
     * @return The status of the removal operation.
     * @throws IllegalArgumentException If the product name is null, empty, or if the quantity is less than or equal to zero.
     */
    public RemovalStatus removeItem(String product, int quantity) {
        if (product == null || product.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        String normalizedProduct = product.toLowerCase().trim();

        if (!items.containsKey(normalizedProduct)) {
            return RemovalStatus.NOT_IN_CART;
        }

        int currentQuantity = items.get(normalizedProduct);
        if (currentQuantity < quantity) {
            return RemovalStatus.NOT_ENOUGH_ITEMS;
        }

        if (currentQuantity == quantity) {
            items.remove(normalizedProduct);
        } else {
            items.put(normalizedProduct, currentQuantity - quantity);
        }

        return RemovalStatus.REMOVED;
    }

    /**
     * Returns the quantity of a specific product in the cart.
     *
     * @param product The name of the product.
     * @return The quantity of the product, or 0 if the product is not in the cart.
     */
    public int getQuantity(String product) {
        if (product == null) return 0;
        return items.getOrDefault(product.toLowerCase().trim(), 0);
    }

    /**
     * Returns an unmodifiable view of the items in the cart.
     *
     * @return An unmodifiable map of products and their quantities.
     */
    public Map<String, Integer> getItems() {
        return Collections.unmodifiableMap(items);
    }

    /**
     * Calculates the total number of all items in the cart.
     *
     * @return The sum of quantities of all products in the cart.
     */
    public int getTotalItems() {
        int total = 0;
        for (int quantity : items.values()) {
            total += quantity;
        }
        return total;
    }
}
