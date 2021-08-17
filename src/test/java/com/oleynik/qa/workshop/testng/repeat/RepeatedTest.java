package com.oleynik.qa.workshop.testng.repeat;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class RepeatedTest {
    @Test(invocationCount = 2)
    public void repeated_test() {
        System.out.println("Multiplication test");
        assertEquals(2*5, 10, "Multiplication result is wrong");// 2*6
    }

    @Test(invocationCount = 4)
    void repetition_info_for_repeated_test(Method method, ITestContext testContext) {
        int invocationCount = Arrays.stream(testContext.getAllTestMethods())
                .filter(m->m.getMethodName().equals(method.getName()))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Cannot get the current invocation count"))
                .getCurrentInvocationCount();
        System.out.println("Repetition " + invocationCount);
        assertEquals(method.getAnnotation(Test.class).invocationCount(), 4);
    }
}
