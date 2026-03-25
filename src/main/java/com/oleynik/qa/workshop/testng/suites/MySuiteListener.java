package com.oleynik.qa.workshop.testng.suites;

import org.testng.ISuite;
import org.testng.ISuiteListener;

/**
 * Demonstrates {@link ISuiteListener} — a TestNG listener that fires
 * once at the very beginning and once at the very end of an entire suite run.
 *
 * <p>Use this interface when you need to perform global setup or teardown
 * that cannot (or should not) be placed inside a test class — for example,
 * starting / stopping an external service, initialising a shared database
 * connection pool, or writing a custom suite-level report.
 *
 * <p><b>JUnit 5 equivalent:</b> a class-level extension implementing
 * {@code BeforeAllCallback} / {@code AfterAllCallback} and registered with
 * {@code @RegisterExtension} or via {@code ServiceLoader}.
 *
 * <h2>Registration</h2>
 * <ul>
 *   <li>Per test class — add {@code @Listeners(MySuiteListener.class)} to the
 *       test class (see {@link SuiteListenerTest}).</li>
 *   <li>Globally — add a {@code <listener>} entry inside the
 *       {@code <listeners>} block of a {@code testng.xml} suite file so that
 *       every suite in the run is covered (see {@code testngsuites.xml}).</li>
 * </ul>
 *
 * <h2>Fixture execution order</h2>
 * <pre>
 * IExecutionListener.onExecutionStart()     ← process-wide, fires once
 *   ISuiteListener.onStart(suite)           ← fires per suite
 *     @BeforeSuite                          ← annotation-based, once per suite
 *       @BeforeTest                         ← once per &lt;test&gt; block in XML
 *         @BeforeClass                      ← once per test class
 *           @BeforeMethod / @Test / @AfterMethod
 *         @AfterClass
 *       @AfterTest
 *     @AfterSuite
 *   ISuiteListener.onFinish(suite)
 * IExecutionListener.onExecutionFinish()
 * </pre>
 *
 * @see MyExecutionListener
 * @see SuiteListenerTest
 */
public class MySuiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        System.out.println("[MySuiteListener] Suite starting: " + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("[MySuiteListener] Suite finished: " + suite.getName());
    }
}

