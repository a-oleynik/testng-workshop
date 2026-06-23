# GitHub Copilot Agent Instructions

This file guides GitHub Copilot in **agent mode** (coding agent / Copilot Workspace) with task recipes for this repository.

## Repository purpose

**TestNG 7 Workshop** — Java 21 Maven project demonstrating every major TestNG 7 feature.  
Companion code for the IT Talk _"JUnit 6 vs TestNG 7"_.

This is a **test-only project**: there is no deployable application.  
`src/main/` contains only shared utilities, listeners, data providers, model classes, and retry infrastructure.

---

## Environment

| Requirement | Version | Notes                                                   |
|-------------|---------|---------------------------------------------------------|
| Java (JDK)  | 21 LTS  | Must be on `PATH` / `JAVA_HOME`                         |
| Maven       | 3.9+    | Optional — Maven Wrapper included (`mvnw` / `mvnw.cmd`) |

No external services, databases, or containers are required.

---

## How to verify changes

Always run the full test suite after any code change:

```bash
mvn clean test
```

A change is complete only when `BUILD SUCCESS` is reported with 0 failures and 0 errors.  
On Windows use `mvnw.cmd clean test` if Maven is not installed locally.

---

## Task recipes

### Add a new test class

1. Identify the correct package under `src/test/java/com/oleynik/qa/workshop/testng/` (see feature map below).
2. Create `<FeatureName>Test.java` — `PascalCase` + `Test` suffix.
3. Use `org.testng.Assert` for assertions (`assertEquals`, `assertTrue`, `assertNull`, …).  
   Use `AssertJ assertThat(...)` **only** in `HamcrestTest` / assumption tests. Do not mix libraries in one class.
4. Name test methods in `snake_case` ending with `_test`, e.g. `assert_equals_multiplication_test`.
5. Do **not** add `public` to test methods — TestNG does not require it.
6. Verify: `mvn clean test -Dtest=<ClassName>`.

### Add a new data-driven test

1. Inline `@DataProvider`: add `@DataProvider(name = "…")` method and `Object[][]` rows in the same class.
2. CSV-based: add rows to `src/test/resources/numbers.csv`, use `DynamicDataProviderTest` as reference.
3. External provider: annotate with `@Test(dataProvider = "myData", dataProviderClass = MyDataProvider.class)`.
4. Verify: `mvn clean test -Dtest=<ClassName>`.

### Add a new listener

1. Create the listener class in `src/main/java/com/oleynik/qa/workshop/testng/listeners/` (no `Test` suffix).
2. Implement the appropriate TestNG interface:
   - `ITestListener` — test start / success / failure / skip events
   - `IInvokedMethodListener` — intercept every method invocation
   - `TestListenerAdapter` — extend and override only the callbacks you need
   - `IAnnotationTransformer` — transform annotations at runtime (e.g. inject retry)
3. Register via `@Listeners(value = MyListener.class)` on the test class **or** add to the `<listeners>` block of a `testng.xml`.
4. **Critical exception**: `IExecutionListener` must be registered in `testng.xml` only — `@Listeners` is silently ignored for this interface.

### Add a retry test (per-method)

1. Annotate the test method:
   ```java
   @Test(retryAnalyzer = RetryAnalyzer.class)
   @Retries(limit = 3)
   void my_retry_test() { ... }
   ```
2. `RetryAnalyzer` reads `@Retries` via reflection — no further wiring required.

### Apply retry globally via transformer

1. Register `RetryTransformer` in `testngretrylistener.xml`:
   ```xml
   <listeners>
       <listener class-name="com.oleynik.qa.workshop.testng.listeners.RetryTransformer"/>
   </listeners>
   ```
2. Run: `mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testngretrylistener.xml`

### Run a specific XML suite

```bash
mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/<suite-file>.xml
```

Available suites in `src/test/resources/`:

| File | What it demonstrates |
|---|---|
| `testng1.xml` | Include / exclude specific methods per class |
| `testng2.xml` | Run fixed classes in parallel (`thread-count="2"`) |
| `testnggroups1.xml` | Groups-of-groups (Smoke + Regression + Fail) |
| `testnggroups2.xml` | Smoke group only |
| `testngretrylistener.xml` | `RetryTransformer` as global listener |
| `testnested.xml` | Run full package including inner classes |
| `testngsuites.xml` | `ISuiteListener` + `IExecutionListener` demo |

### Run tests by group

```bash
mvn clean test -Dgroups=Smoke,Regression
```

### Generate HTML report

```bash
mvn clean surefire-report:report
# Output: target/reports/surefire.html
```

---

## Feature → package map

| Feature | Package | Key class(es) |
|---|---|---|
| Basic assertions | `general` | `AssertTest` |
| Fixtures / lifecycle | `general` | `FixturesTest` |
| Exception testing | `general` | `ExceptionTest` |
| Timeouts | `general` | `TimeoutTest` |
| Disabling / skipping | `general` | `DisabledTest` |
| Hamcrest matchers | `general` | `HamcrestTest` |
| Soft assertions | `group/asserts` | `SoftAssertTest` |
| Assumptions | `conditional` | `AssumeTest`, `AssumeBeforeClassTest` |
| Data providers (static) | `ddt` | `StaticDataProviderTest` |
| Data providers (CSV) | `ddt` | `DynamicDataProviderTest` |
| External data provider | `ddt` | `OuterDataProviderTest` |
| Nested test classes | `nested` | `NestedTest` |
| Groups | `grouping` | `GroupTest` |
| Test dependencies | `dependencies` | `DependenciesTest` |
| Execution ordering | `execution/order` | `ExecutionOrderTest` |
| Suite annotations | `suites` | `SuiteAnnotationsTest` |
| Test-block annotations | `suites` | `TestAnnotationsTest` |
| ISuiteListener | `suites` | `SuiteListenerTest` + `MySuiteListener` |
| IExecutionListener | `suites` | `ExecutionListenerTest` + `MyExecutionListener` |
| ITestListener | `listeners` | `TestListenerTest` + `MyTestListener` |
| IInvokedMethodListener | `listeners` | `MethodListenerTest` + `MyMethodListener` |
| TestListenerAdapter | `listeners` | `TestListenerTest` + `MyExtendedTestListener` |
| Retry (IRetryAnalyzer) | `retry` | `RetryTest` + `RetryAnalyzer` |
| Retry (transformer) | `retry` | `RetryTransformerTest` + `RetryTransformer` |
| Repeated execution | `repeat` | `RepeatedTest` |

---

## Hard constraints — never violate

- Do **not** use `@org.junit.jupiter.api.Test` — this project is TestNG-only.
- Do **not** introduce static mutable state in test classes — `parallel=methods`, `threadCount=3` is active by default.
- Do **not** register `IExecutionListener` via `@Listeners` — it will be silently ignored.
- Do **not** modify `<parallel>` in `pom.xml` without auditing all test classes for shared mutable state.
- Do **not** remove Lombok from `pom.xml` or from the compiler annotation processor path.
- Do **not** mix assertion libraries within the same test class.

