package com.oleynik.qa.workshop.testng.fixtures;

import com.oleynik.qa.workshop.testng.model.ShoppingCart;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Inline Setup + Fresh Fixture: each test creates its own cart inside the test method.
 * Compare with ImplicitFixtureTest: the scenarios and assertions are the same.
 */
public class InlineFixtureTest {

    @Test
    void calculate_total_for_two_items_test() {
        // The empty cart and its state are the fixture; constructing it is setup.
        ShoppingCart cart = new ShoppingCart();
        assertEquals(cart.getTotal(), 0);

        cart.addItem(200, 2);

        assertEquals(cart.getTotal(), 400);
    }

    @Test
    void calculate_total_for_different_items_test() {
        ShoppingCart cart = new ShoppingCart();
        assertEquals(cart.getTotal(), 0);

        cart.addItem(200, 2);
        cart.addItem(50, 1);

        assertEquals(cart.getTotal(), 450);
    }
}
