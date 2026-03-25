package com.oleynik.qa.workshop.testng.suites;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * Demonstrates {@link MyExecutionListener} — an
 * {@link org.testng.IExecutionListener} that wraps the entire TestNG run,
 * firing before the first suite starts and after the last suite finishes.
 *
 * <p>{@code IExecutionListener} provides two callback methods:
 * <ul>
 *   <li>{@code onExecutionStart()} — invoked once before TestNG begins any
 *       suite in this JVM run.</li>
 *   <li>{@code onExecutionFinish()} — invoked once after all suites have
 *       completed.</li>
 * </ul>
 *
 * <p>This is coarser-grained than {@link MySuiteListener}: while
 * {@code ISuiteListener} fires once <em>per suite</em>, this listener fires
 * exactly once <em>per process</em>, regardless of how many suites are run.
 * Use it for truly global infrastructure — for example, starting a Docker
 * container or recording a JVM-wide metric.
 *
 * <p><b>Important:</b> {@code IExecutionListener} <strong>cannot</strong> be
 * registered via the {@code @Listeners} annotation on a test class.
 * It must be declared in the {@code <listeners>} block of a
 * {@code testng.xml} suite file. Run this test through the provided
 * {@code testngsuites.xml} to observe the listener output:
 *
 * <pre>
 * mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testngsuites.xml
 * </pre>
 *
 * <p><b>JUnit 5 equivalent:</b> there is no direct equivalent; the closest
 * approaches are a {@code LauncherSessionListener} or a JVM-level extension
 * registered via {@code ServiceLoader}.
 *
 * @see MyExecutionListener
 * @see SuiteListenerTest
 */
public class ExecutionListenerTest {
    @Test
    public void execution_listener_multiplication_test() {
        System.out.println("Multiplication test");
        Assert.assertEquals(2 * 5, 10, "Multiplication result is wrong");
    }
    @Test
    public void execution_listener_division_test() {
        System.out.println("Division test");
        Assert.assertEquals(10 / 5.0, 2.0, 0);
    }
    @Test
    public void execution_listener_boolean_test() {
        System.out.println("Boolean test");
        boolean variable = true;
        Assert.assertTrue(variable, "variable is not true");
        Assert.assertFalse(!variable, "!variable is not false");
    }
}
