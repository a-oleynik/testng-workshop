package com.oleynik.qa.workshop.testng.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListener implements ITestListener{
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("on test method " +  getTestMethodName(result) + " start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("on test method " + getTestMethodName(result) + " success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("on test method " + getTestMethodName(result) + " failure");
        //Screenshot!
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("test method " + getTestMethodName(result) + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("test failed but within success % " + getTestMethodName(result));
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("on start of test " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("on finish of test " + context.getName());
    }

    private static String getTestMethodName(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();
    }
}
