package com.oleynik.qa.workshop.testng.group.asserts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {

    @Test
    public void soft_assert_test() {
        System.out.println("Soft Assertion test");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(2 * 5, 10, "Multiplication result is wrong");//11
        softAssert.assertEquals(10 / 5.0, 2.1, 0.2);//0.1
        boolean variable = true;//false
        softAssert.assertTrue(variable, "The variable is not true");
        softAssert.assertFalse(!variable, "The !variable is not false");
        softAssert.assertAll();
    }
}
