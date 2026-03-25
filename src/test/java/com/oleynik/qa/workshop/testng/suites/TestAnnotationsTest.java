package com.oleynik.qa.workshop.testng.suites;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/**
 * Demonstrates {@code @BeforeTest} and {@code @AfterTest} - fixtures that
 * run once for every {@code <test>} element defined in a TestNG XML suite
 * file, wrapping all test classes grouped under that element.
 *
 * <p>A single {@code <test>} block in a {@code testng.xml} may contain
 * multiple test classes. {@code @BeforeTest} runs once before the first
 * class in that block is executed; {@code @AfterTest} runs once after the
 * last class finishes. This makes them coarser-grained than
 * {@code @BeforeClass} / {@code @AfterClass} but finer-grained than
 * {@code @BeforeSuite} / {@code @AfterSuite}.
 *
 * <p><b>JUnit 5 equivalent:</b> there is no direct equivalent; the closest
 * approach is to group test classes into separate launcher suites and use
 * suite-level extensions.
 *
 * <p><b>Standalone run note:</b> when this class is executed without a
 * {@code testng.xml} (e.g. directly from an IDE or via
 * {@code -Dtest=TestAnnotationsTest}), TestNG wraps it in an implicit
 * single-class {@code <test>} element, so {@code @BeforeTest} and
 * {@code @AfterTest} fire exactly once - the same as {@code @BeforeClass}
 * / {@code @AfterClass} in that scenario.
 *
 * <h2>Fixture execution order (with testng.xml)</h2>
 * <pre>
 * @BeforeSuite
 *   @BeforeTest   fires once per &lt;test&gt; block
 *     @BeforeClass
 *       @BeforeMethod / @Test / @AfterMethod   (repeated per test method)
 *     @AfterClass
 *   @AfterTest    fires once per &lt;test&gt; block
 * @AfterSuite
 * </pre>
 *
 * @see SuiteAnnotationsTest
 * @see MySuiteListener
 */
public class TestAnnotationsTest {
    @BeforeTest
    public void testSetUp() {
        System.out.println("[TestAnnotationsTest] @BeforeTest - test-block set-up");
    }
    @AfterTest
    public void testTearDown() {
        System.out.println("[TestAnnotationsTest] @AfterTest - test-block tear-down");
    }
    @BeforeClass
    public void classSetUp() {
        System.out.println("[TestAnnotationsTest] @BeforeClass");
    }
    @AfterClass
    public void classTearDown() {
        System.out.println("[TestAnnotationsTest] @AfterClass");
    }
    @BeforeMethod
    public void setUp() {
        System.out.println("[TestAnnotationsTest] @BeforeMethod");
    }
    @AfterMethod
    public void tearDown() {
        System.out.println("[TestAnnotationsTest] @AfterMethod");
    }
    @Test
    public void test_annotations_multiplication_test() {
        System.out.println("Multiplication test");
        Assert.assertEquals(2 * 5, 10, "Multiplication result is wrong");
    }
    @Test
    public void test_annotations_division_test() {
        System.out.println("Division test");
        Assert.assertEquals(10 / 5.0, 2.0, 0);
    }
    @Test
    public void test_annotations_boolean_test() {
        System.out.println("Boolean test");
        boolean variable = true;
        Assert.assertTrue(variable, "variable is not true");
        Assert.assertFalse(!variable, "!variable is not false");
    }
}
