package com.oleynik.qa.workshop.testng.suites;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
/**
 * Demonstrates {@link MySuiteListener} — an {@link org.testng.ISuiteListener}
 * attached to this test class via the {@code @Listeners} annotation.
 *
 * <p>{@code ISuiteListener} provides two callback methods:
 * <ul>
 *   <li>{@code onStart(ISuite)} — invoked before TestNG begins running any
 *       test in the suite.</li>
 *   <li>{@code onFinish(ISuite)} — invoked after all tests in the suite have
 *       finished, including teardown methods.</li>
 * </ul>
 *
 * <p>Unlike {@code @BeforeSuite} / {@code @AfterSuite} annotations (which
 * live inside a test class and can conflict when multiple classes define
 * them), {@code ISuiteListener} is infrastructure-level code that stays
 * outside the test class hierarchy. This makes it the preferred approach for
 * shared setup such as starting a database container or opening a browser
 * session that must be available to every test in the suite.
 *
 * <p><b>JUnit 5 equivalent:</b> a custom extension implementing
 * {@code BeforeAllCallback} / {@code AfterAllCallback} and registered via
 * {@code @RegisterExtension} or {@code ServiceLoader}.
 *
 * <h2>Registration options</h2>
 * <ul>
 *   <li><b>Per class</b> — {@code @Listeners(MySuiteListener.class)} on the
 *       test class (as shown here). The listener is activated for the suite
 *       that contains this class.</li>
 *   <li><b>Globally</b> — add the listener to the {@code <listeners>} block
 *       of a {@code testng.xml} file so it fires for every suite that uses
 *       that XML (see {@code testngsuites.xml}).</li>
 * </ul>
 *
 * @see MySuiteListener
 * @see SuiteAnnotationsTest
 */
@Listeners(MySuiteListener.class)
public class SuiteListenerTest {
    @Test
    public void suite_listener_multiplication_test() {
        System.out.println("Multiplication test");
        Assert.assertEquals(2 * 5, 10, "Multiplication result is wrong");
    }
    @Test
    public void suite_listener_division_test() {
        System.out.println("Division test");
        Assert.assertEquals(10 / 5.0, 2.0, 0);
    }
    @Test
    public void suite_listener_boolean_test() {
        System.out.println("Boolean test");
        boolean variable = true;
        Assert.assertTrue(variable, "variable is not true");
        Assert.assertFalse(!variable, "!variable is not false");
    }
}
