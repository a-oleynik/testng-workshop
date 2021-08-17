package com.oleynik.qa.workshop.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
/*@Test*/
public class AssertTest {

    @Test
    public void multiplication_test(){
        System.out.println("Multiplication test.");
        Assert.assertEquals(2*5, 10, "Multiplication result is wrong");
    }

    @Test
    public void division_test(){
        System.out.println("Division test.");
        Assert.assertEquals(10/5.0, 2.0, 0);
    }

    @Test
    public void boolean_test(){
        boolean variable = true;
        Assert.assertTrue(variable, "variable is not true");
        Assert.assertFalse(!variable, "!variable is not false");
    }

    @Test
    public void fail_test(){
        Assert.fail("The test is failed somehow.");
    }
}
