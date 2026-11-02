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
 * <p>{@code ISuiteListener} keeps infrastructure-level setup outside the
 * test-class hierarchy. Suite annotations may also be declared in multiple
 * test classes. Choose a listener when that separation suits the resource
 * owner, and keep any shared resource safe for the suite's parallel execution.
 *
 * <p><b>JUnit comparison:</b> JUnit Platform suite hooks have suite scope.
 * Jupiter's {@code BeforeAllCallback} / {@code AfterAllCallback} have
 * class scope, including when the extension is discovered via {@code ServiceLoader}.
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
