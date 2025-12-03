package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    public void setUp() {
        cart= new ShoppingCart();
    }

    @Test
    public void testAddNullProduct() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem(null, 1);
        });
    }

    @Test
    public void testAddEmptyProduct() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("   ", 1);
        });
    }

    @Test
    public void testAddNegativeQuantity() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Apple", -5);
        });
    }

    @Test
    public void testAddZeroQuantity() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Banana", 0);
        });
    }

    @Test
    public void testAddPositiveQuantity() {
        cart.addItem("Apple", 1);
        assertEquals(1, cart.getItems().get("apple"));
    }

    @Test
    public void testAddNormalizedName(){
        cart.addItem("  ApPlE  ", 2);
        cart.addItem("Apple", 3);
        assertEquals(5, cart.getItems().get("apple"));
    }


}