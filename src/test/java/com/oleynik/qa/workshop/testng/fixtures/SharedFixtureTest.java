package com.oleynik.qa.workshop.testng.fixtures;

import com.oleynik.qa.workshop.testng.model.ShoppingCart;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * Shared Fixture: both tests reuse the same immutable price catalog.
 * Each test also gets a Fresh Fixture: its own mutable shopping cart.
 * Lifecycle callbacks prepare these fixtures; the callbacks are not fixtures.
 * The methods run in one thread to isolate the cart field under parallel=methods.
 */
@Test(singleThreaded = true)
public class SharedFixtureTest {
    private Map<String, Integer> productPrices;
    private ShoppingCart cart;

    @BeforeClass
    void load_shared_catalog() {
        // Shared reference data, created once per instance and never changed by tests.
        productPrices = Map.of("book", 200, "pen", 50);
    }

    @BeforeMethod
    void create_empty_cart() {
        // Implicit Setup creates a fresh cart, while the catalog is reused.
        cart = new ShoppingCart();
    }

    @Test
    void calculate_total_for_two_items_test() {
        assertEquals(cart.getTotal(), 0);

        cart.addItem(productPrices.get("book"), 2);

        assertEquals(cart.getTotal(), 400);
    }

    @Test
    void calculate_total_for_different_items_test() {
        assertEquals(cart.getTotal(), 0);

        cart.addItem(productPrices.get("book"), 2);
        cart.addItem(productPrices.get("pen"), 1);

        assertEquals(cart.getTotal(), 450);
    }
}
