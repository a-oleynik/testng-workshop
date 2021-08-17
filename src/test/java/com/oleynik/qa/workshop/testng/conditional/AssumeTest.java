package com.oleynik.qa.workshop.testng.conditional;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;

public class AssumeTest {
    private static final String OS = System.getProperty("os.name");// Windows 10

    @BeforeMethod
    public void checkOs(Method method) {
        String name = method.getName();
        System.out.printf("Starting AssertTest#%s", method.getName());
        assumeThat(name).withFailMessage("The test method name doesn't assume anything").contains("assume");
    }

    @Test
    public void assume_that_equals_test() {
        assumeThat(OS).withFailMessage("The OS is not Unix").isEqualTo("Unix");
        // ... this assertion is not performed
        assertThat(OS).contains("Unix");
    }

    @Test
    public void assume_that_contains_test() {
        assumeThat(OS).withFailMessage("Detected os is not Windows 10").contains("Windows");
        assertThat(OS).contains("Windows");
    }
}
