package com.oleynik.qa.workshop.testng.listeners;

import com.oleynik.qa.workshop.testng.retry.RetryAnalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryTransformer implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        System.out.println("Transforming " + testMethod.getName());
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}
