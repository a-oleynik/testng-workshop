package com.oleynik.qa.workshop.testng.conditional;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;

public class AssumeBeforeClassTest {
    private static final String OS = System.getProperty("os.name");// Windows 10

    @BeforeClass
    public static void checkOs() {
        System.out.println("Starting AssertTest");
        assumeThat(OS).withFailMessage("The OS is not Linux").isEqualTo("Linux");// "Windows 10"
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

    @AfterClass(alwaysRun = true)
    public static void afterExecution() {
        System.out.println("Finishing AssumptionsTest");
    }
}
