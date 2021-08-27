package com.oleynik.qa.workshop.testng.retry;

import com.oleynik.qa.workshop.testng.annotations.Retries;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Retries(limit = 3)
    public void retry_equals_multiplication_test() {
        System.out.println("Multiplication test");
        Assert.assertEquals(2*5, 10, "Multiplication result is wrong");//11
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Retries(limit = 3)
    public void retry_equals_division_test(){
        System.out.println("Division test");
        Assert.assertEquals(10/5.0, 2, 0);//1.9
    }
}
