package com.oleynik.qa.workshop.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {

    @Test
    public void soft_assert_test(){
        System.out.println("Soft Assertion test.");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(2*5, 11, "Multiplication result is wrong");
        softAssert.assertEquals(10/5.0, 2.1, 0);
        boolean variable = true;
        softAssert.assertTrue(!variable, "The variable is not true");
        softAssert.assertFalse(variable, "The !variable is not false");
        softAssert.assertAll();
    }
}
