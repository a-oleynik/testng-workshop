package com.oleynik.qa.workshop.testng;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class IgnoringTest {

    @Test(enabled = false)
    public void ignoring_multiplication_test(){
        System.out.println("Multiplication test.");
        Assert.assertEquals(2*5, 10, "Multiplication result is wrong");
    }

    @Test(enabled = true)
    public void ignoring_division_test(){
        System.out.println("Division test.");
        Assert.assertEquals(10/5.0, 2.0, 0);
    }

    @Test(enabled = true)
    public void ignoring_boolean_test(){
        System.out.println("Boolean test.");
        boolean variable = true;
        Assert.assertTrue(variable, "variable is not true");
        Assert.assertFalse(!variable, "!variable is not false");
    }

    @Test(enabled = true)
    public void ignoring_fail_test(){
        System.out.println("Fail test.");
        throw new SkipException("Test skipped.");
        //Assert.fail("The test is failed somehow.");
    }
}
