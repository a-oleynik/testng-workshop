package com.oleynik.qa.workshop.testng.listeners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class MyExtendedTestListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("on test method " + getTestMethodName(result) + " failure");
        //Screenshot!
    }

    private static String getTestMethodName(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();
    }
}
