package com.oleynik.qa.workshop.testng.general;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Logs TestNG lifecycle callbacks and their scopes.
 * The callbacks demonstrate execution order; fixture state and setup styles
 * are demonstrated separately in the fixtures package.
 */
@Test(singleThreaded = true)
public class LifecycleTest {
    private static final String ACTUAL = "Actual string";
    private static final String EXPECTED = "Actual string";// "Expected string"

    @BeforeSuite
    public void globalSetUp() {
        System.out.println("Set up suite");
    }

    @AfterSuite
    public void globalTearDown() {
        System.out.println("Tear down suite");
    }

    @BeforeClass
    public void classSetUp() {
        System.out.println("Set up class");
    }

    @AfterClass
    public void classTearDown() {
        System.out.println("Tear down class");
    }

    @BeforeTest
    public void testSetUp() {
        System.out.println("Set up \"test\"");
    }

    @AfterTest
    public void testTearDown() {
        System.out.println("Tear down \"test\"");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Set up method");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Tear down method");
    }

    @Test
    void lifecycle_the_first_test() {
        System.out.println("The first test");
        assertEquals(ACTUAL, EXPECTED, "Wrong string found");
    }

    @Test
    void lifecycle_the_second_test() {
        System.out.println("The second test");
        assertEquals(ACTUAL, ACTUAL, "Wrong string found");
    }
}
