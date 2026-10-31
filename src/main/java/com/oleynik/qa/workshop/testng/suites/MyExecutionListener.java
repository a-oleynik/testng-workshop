package com.oleynik.qa.workshop.testng.suites;
import org.testng.IExecutionListener;
/**
 * Demonstrates {@link IExecutionListener} - the coarsest-grained TestNG
 * lifecycle hook, called exactly once per TestNG execution (one run of the
 * TestNG engine, e.g. one {@code mvn test} / one {@code TestNG.run()} call),
 * regardless of how many suites are executed inside that run. A single JVM
 * can perform several such executions in sequence.
 *
 * <p>Prefer {@link MySuiteListener} when you only need suite-scoped setup;
 * use {@code IExecutionListener} when you need to initialise or tear down
 * resources that span <em>across multiple suites</em> within one execution.
 *
 * <p><b>JUnit 5 equivalent:</b> there is no exact match; the closest
 * approach is a JVM-level extension registered via {@code ServiceLoader}
 * or a global {@code LauncherSessionListener}.
 *
 * <h2>Registration</h2>
 * {@code IExecutionListener} extends {@code ITestNGListener}, so it can be
 * attached via the {@code @Listeners} annotation on a test class, declared
 * in the {@code <listeners>} block of a {@code testng.xml} suite file, or
 * auto-detected via {@code ServiceLoader}
 * ({@code META-INF/services/org.testng.ITestNGListener}). The
 * "XML only, {@code @Listeners} is ignored" restriction applies to
 * {@code IAnnotationTransformer}, not to {@code IExecutionListener}.
 * This Workshop registers it in {@code testngsuites.xml} so it reliably
 * wraps every suite in the demo run — see {@code testngsuites.xml}.
 *
 * <h2>Fixture execution order</h2>
 * <pre>
 * IExecutionListener.onExecutionStart()   fires once before all suites
 *   ISuiteListener.onStart(suite)         fires per suite
 *     @BeforeSuite / @BeforeTest / @BeforeClass / @BeforeMethod
 *   ISuiteListener.onFinish(suite)
 * IExecutionListener.onExecutionFinish()  fires once after all suites
 * </pre>
 *
 * @see MySuiteListener
 * @see ExecutionListenerTest
 */
public class MyExecutionListener implements IExecutionListener {
    @Override
    public void onExecutionStart() {
        System.out.println("[MyExecutionListener] Execution starting - before all suites");
    }
    @Override
    public void onExecutionFinish() {
        System.out.println("[MyExecutionListener] Execution finished - after all suites");
    }
}