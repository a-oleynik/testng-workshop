package com.oleynik.qa.workshop.testng.retry;

import com.oleynik.qa.workshop.testng.annotations.Retries;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.lang.reflect.Method;

public class RetryAnalyzer implements IRetryAnalyzer {

    int counter = 0;
    private int retryLimit;

    @Override
    public boolean retry(ITestResult iTestResult) {
        Method method = iTestResult.getMethod().getConstructorOrMethod().getMethod();
        if (method.isAnnotationPresent(Retries.class)) {
            retryLimit = method.getAnnotation(Retries.class).limit();
        } else {
            throw new RuntimeException("Retries annotation is not found");
        }
        if (!iTestResult.isSuccess()) {
            if (counter < retryLimit) {
                counter++;
                iTestResult.setStatus(ITestResult.FAILURE);
                return true;
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
}
