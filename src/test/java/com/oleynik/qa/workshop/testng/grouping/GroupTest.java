package com.oleynik.qa.workshop.testng.grouping;


import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import static java.lang.String.format;

public class GroupTest {

    @BeforeGroups(groups = "Smoke")
    public void smokeSetUp(){
        System.out.println("Smoke set up");
    }

    @AfterGroups(groups = "Smoke")
    public void smokeTearDown(){
        System.out.println("Smoke tear down");
    }

    @Test(groups = { "Smoke", "Regression" })
    public void group_multiplication_test(){
        System.out.println("Multiplication test");
        Assert.assertEquals(2*5, 10, "Multiplication result is wrong");
    }

    @Test(groups = { "Regression" })
    public void group_division_test(){
        System.out.println("Division test");
        Assert.assertEquals(10/5.0, 2.0, 0);
    }

    @Test(groups = { "Regression" })
    public void group_boolean_test(){
        System.out.println("Boolean test");
        boolean variable = true;
        Assert.assertTrue(variable, "variable is not true");
        Assert.assertFalse(!variable, "!variable is not false");
    }

    @Test(groups = { "Fail" })
    public void group_fail_test(){
        System.out.println("Fail test");
        boolean isFailed = false;
        if (isFailed) {
            Assert.fail(format("The test is failed because isFailed equals to %s", isFailed));
        }
    }

}
