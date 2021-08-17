package com.oleynik.qa.workshop.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterizationTest {

    @DataProvider(name = "factorial")
    public static Object[][] multiplyNumbers() {
        return new Object[][]{{1,1},{2,2},{3,6},{4,24},{5,120}};
    }

    @Test(dataProvider = "factorial")
    public void test_factorial(long number, long expected){
        Assert.assertEquals(Factorial.factorial(number), expected, "Factorial function works wrong.");
    }
}
