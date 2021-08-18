package com.oleynik.qa.workshop.testng.execution.order;

import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.String.format;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ExecutionOrderTest {
    @Test
    public void execution_order_with_fail_test() {
        boolean isFailed = false;
        if (isFailed) {
            fail(format("The test is failed because isFailed equals to %s", isFailed));
        }
    }

    @Test(priority = 3)
    public void execution_order_with_multiplication_test() {
        System.out.println("Multiplication test");
        assertEquals(2*5, 10, "Multiplication result is wrong");
    }

    @Test(priority = 1)
    public void execution_order_with_division_test() {
        System.out.println("Division test");
        assertEquals(2.0, 10 / 5.0, 0);
    }

    @Test(priority = 3)
    public void execution_order_with_boolean_test() {
        boolean variable = true;
        Assert.assertTrue(variable, "variable is not true");
        Assert.assertFalse(!variable, "!variable is not false");
    }
}
