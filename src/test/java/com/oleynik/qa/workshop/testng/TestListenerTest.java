package com.oleynik.qa.workshop.testng;

import com.oleynik.qa.workshop.testng.listeners.MyTestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(value = MyTestListener.class)
public class TestListenerTest {

    @Test
    public void method_listener_multiplication_test(){
        System.out.println("Multiplication test.");
        Assert.assertEquals(2*5, 10, "Multiplication result is wrong");
    }

    @Test
    public void method_listener_division_test(){
        System.out.println("Division test.");
        Assert.assertEquals(10/5.0, 2.0, 0);
    }

    @Test
    public void method_listener_boolean_test(){
        System.out.println("Boolean test.");
        boolean variable = true;
        Assert.assertTrue(variable, "variable is not true");
        Assert.assertFalse(!variable, "!variable is not false");
    }

    @Test
    public void method_listener_fail_test(){
        System.out.println("Fail test.");
        Assert.fail("The test is failed somehow.");
    }
}
