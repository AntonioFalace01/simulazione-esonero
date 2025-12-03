package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}