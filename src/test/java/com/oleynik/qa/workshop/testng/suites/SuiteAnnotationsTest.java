package com.oleynik.qa.workshop.testng.suites;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
/**
 * Demonstrates the built-in {@code @BeforeSuite} and {@code @AfterSuite}
 * annotations - the simplest way to execute global setup and teardown once
 * per TestNG suite, directly from a test class.
 *
 * <p>{@code @BeforeSuite} runs before any test class in the suite is
 * instantiated; {@code @AfterSuite} runs after the last test method across
 * all classes in the suite has completed.
 *
 * <p><b>JUnit 5 equivalent:</b> {@code @BeforeAll} / {@code @AfterAll} in a
 * shared base class, or a class-level extension implementing
 * {@code BeforeAllCallback} / {@code AfterAllCallback} registered with
 * {@code @RegisterExtension}.
 *
 * <h2>Fixture execution order</h2>
 * <pre>
 * @BeforeSuite   (once per suite)
 *   @BeforeTest  (once per &lt;test&gt; block in testng.xml)
 *     @BeforeClass (once per test class)
 *       @BeforeMethod
 *         @Test
 *       @AfterMethod
 *     @AfterClass
 *   @AfterTest
 * @AfterSuite    (once per suite)
 * </pre>
 *
 * <p><b>Tip:</b> Only one {@code @BeforeSuite} method fires per suite,
 * even when multiple test classes define one - TestNG picks the first it
 * finds. Prefer {@link MySuiteListener} for shared, infrastructure-level
 * setup that should reliably run regardless of which class is loaded first.
 *
 * @see TestAnnotationsTest
 * @see MySuiteListener
 */
public class SuiteAnnotationsTest {
    @BeforeSuite
    public void globalSetUp() {
        System.out.println("[SuiteAnnotationsTest] @BeforeSuite - suite-level set-up");
    }
    @AfterSuite
    public void globalTearDown() {
        System.out.println("[SuiteAnnotationsTest] @AfterSuite - suite-level tear-down");
    }
    @BeforeClass
    public void classSetUp() {
        System.out.println("[SuiteAnnotationsTest] @BeforeClass");
    }
    @AfterClass
    public void classTearDown() {
        System.out.println("[SuiteAnnotationsTest] @AfterClass");
    }
    @BeforeMethod
    public void setUp() {
        System.out.println("[SuiteAnnotationsTest] @BeforeMethod");
    }
    @AfterMethod
    public void tearDown() {
        System.out.println("[SuiteAnnotationsTest] @AfterMethod");
    }
    @Test
    public void suite_annotations_multiplication_test() {
        System.out.println("Multiplication test");
        Assert.assertEquals(2 * 5, 10, "Multiplication result is wrong");
    }
    @Test
    public void suite_annotations_division_test() {
        System.out.println("Division test");
        Assert.assertEquals(10 / 5.0, 2.0, 0);
    }
    @Test
    public void suite_annotations_boolean_test() {
        System.out.println("Boolean test");
        boolean variable = true;
        Assert.assertTrue(variable, "variable is not true");
        Assert.assertFalse(!variable, "!variable is not false");
    }
}
