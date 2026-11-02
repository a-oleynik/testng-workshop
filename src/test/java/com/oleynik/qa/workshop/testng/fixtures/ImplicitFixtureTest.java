package com.oleynik.qa.workshop.testng.fixtures;

import com.oleynik.qa.workshop.testng.model.ShoppingCart;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Implicit Setup + Fresh Fixture: a lifecycle callback prepares a new cart before each test.
 * The cart and its state are the fixture; the callback is the setup mechanism.
 * TestNG reuses the test instance, so this class runs its methods in one thread
 * to prevent concurrent replacement of the cart field under parallel=methods.
 */
@Test(singleThreaded = true)
public class ImplicitFixtureTest {
    private ShoppingCart cart;

    @BeforeMethod
    void create_empty_cart() {
        cart = new ShoppingCart();
    }

    @Test
    void calculate_total_for_two_items_test() {
        assertEquals(cart.getTotal(), 0);

        // Scenario-specific prices and quantities stay visible in the test.
        cart.addItem(200, 2);

        assertEquals(cart.getTotal(), 400);
    }

    @Test
    void calculate_total_for_different_items_test() {
        assertEquals(cart.getTotal(), 0);

        cart.addItem(200, 2);
        cart.addItem(50, 1);

        assertEquals(cart.getTotal(), 450);
    }
}
