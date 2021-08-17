package com.oleynik.qa.workshop.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Example1Test {
    @Test
    public void example1_the_first_test(){
        Assert.assertEquals("Actual string", "Expected string", "Wrong string found.");
    }

    @Test
    public void example1_the_second_test(){
        Assert.assertEquals("Actual string", "Actual string", "Wrong string found.");
    }
}
