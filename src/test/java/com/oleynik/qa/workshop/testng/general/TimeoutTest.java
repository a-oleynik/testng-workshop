package com.oleynik.qa.workshop.testng.general;

import com.oleynik.qa.workshop.testng.Utils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TimeoutTest {
    @BeforeMethod
    public void setUp(){
        Utils.waitFor(1);
        System.out.println("Set up.");
        System.out.println("Set up id " + Thread.currentThread().getId());
    }

    @AfterMethod
    public void tearDown(){
        Utils.waitFor(1);
        System.out.println("Tear down.");
        System.out.println("Tear down id " + Thread.currentThread().getId());
    }

    @Test(timeOut = 6000)
    public void timeout_test(){
        System.out.println("Timeout test.");
        System.out.println("Test id " + Thread.currentThread().getId());
        Utils.waitFor(2);
    }

    @Test(timeOut = 2000)
    public void timeout_test2(){
        System.out.println("Timeout test.");
        System.out.println("Test id " + Thread.currentThread().getId());
        Utils.waitFor(1);//10
    }
}
