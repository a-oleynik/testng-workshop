package com.oleynik.qa.workshop.testng.listeners;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static java.lang.String.format;

@Listeners(value = MyMethodListener.class)
public class MethodListenerTest {
    @BeforeMethod
    public void setUp() {
        System.out.println("Set up method");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Tear down method");
    }

    @Test
    public void method_listener_multiplication_test() {
        System.out.println("Multiplication test");
        Assert.assertEquals(2 * 5, 10, "Multiplication result is wrong");
    }

    @Test
    public void method_listener_division_test() {
        System.out.println("Division test");
        Assert.assertEquals(10 / 5.0, 2.0, 0);
    }

    @Test
    public void method_listener_boolean_test() {
        System.out.println("Boolean test");
        boolean variable = true;
        Assert.assertTrue(variable, "variable is not true");
        Assert.assertFalse(!variable, "!variable is not false");
    }

    @Test
    public void method_listener_fail_test() {
        System.out.println("Fail test");
        boolean isFailed = false;
        if (isFailed) {
            Assert.fail(format("The test is failed because isFailed equals to %s", isFailed));
        }
    }
}
