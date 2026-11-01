# GitHub Copilot Instructions

## Project Overview

This is a **TestNG 7 workshop** project — a hands-on reference and learning resource demonstrating every major TestNG 7 feature in Java 21.  
It is the companion code for the IT Talk _"JUnit 6 vs TestNG 7"_.

## Tech Stack

| Tool / Library        | Version |
|-----------------------|---------|
| Java                  | 21 LTS  |
| TestNG                | 7.12.0  |
| AssertJ               | 3.27.7  |
| Hamcrest              | 3.0     |
| Lombok                | 1.18.48 |
| OpenCSV               | 5.12.0  |
| SLF4J                 | 2.0.18  |
| Maven Surefire Plugin | 3.5.6   |
| Build tool            | Maven   |

## Documentation structure ordering

All documented directory/file trees and source-layout inventories, including layout tables, must follow these rules:

- At every hierarchy level, list directories first, then files.
- Within each group, sort entries alphabetically by name, case-insensitively. Include dot-prefixed entries in the same ordering using their literal names.
- Apply this ordering recursively, including nested directories and collapsed paths.
- Check documented paths against the checkout and preserve comments and descriptions when reordering.

## Project Structure

```
src/main/java/com/oleynik/qa/workshop/testng/
  annotations/     # @Retries, @DataSource — custom annotations
  dataproviders/   # MyDataProvider — reusable external @DataProvider
  listeners/       # MyTestListener, MyMethodListener, MyExtendedTestListener, RetryTransformer
  model/           # User, MyDoubleWrapper — domain model (Lombok builders)
  retry/           # RetryAnalyzer — IRetryAnalyzer implementation
  suites/          # MySuiteListener (ISuiteListener), MyExecutionListener (IExecutionListener)
  Factorial.java   # Utility used by data-driven tests
  Utils.java       # Shared utilities (e.g. waitFor)

src/test/java/com/oleynik/qa/workshop/testng/
  conditional/     # AssumeTest, AssumeBeforeClassTest
  ddt/             # StaticDataProviderTest, DynamicDataProviderTest, OuterDataProviderTest
  dependencies/    # DependenciesTest
  execution/order/ # ExecutionOrderTest
  general/         # AssertTest, ExceptionTest, FixturesTest, HamcrestTest,
                   # TimeoutTest, DisabledTest, DescriptionTest
  group/asserts/   # SoftAssertTest
  grouping/        # GroupTest
  listeners/       # TestListenerTest, MethodListenerTest
  nested/          # NestedTest (inner-class grouping)
  repeat/          # RepeatedTest
  retry/           # RetryTest, RetryTransformerTest
  suites/          # SuiteAnnotationsTest, TestAnnotationsTest, SuiteListenerTest, ExecutionListenerTest

src/test/resources/
  numbers.csv              # CSV test data for DynamicDataProviderTest / OuterDataProviderTest
  testnested.xml           # Run full package including inner classes
  testng1.xml              # Include/exclude specific methods per class
  testng2.xml              # Run fixed set of classes in parallel
  testnggroups1.xml        # Groups-of-groups
  testnggroups2.xml        # Smoke group only
  testngretrylistener.xml  # RetryTransformer registered globally
  testngsuites.xml         # ISuiteListener + IExecutionListener + suite annotations
```

## Coding Conventions

- **Test method names**: `snake_case` with a descriptive suffix, e.g. `assert_equals_multiplication_test`, `retry_equals_division_test`.
- **Test class names**: `PascalCase` ending in `Test`, e.g. `AssertTest`, `RetryTransformerTest`.
- **Production classes** (listeners, analyzers, data providers): `PascalCase`, no `Test` suffix, e.g. `MyTestListener`, `RetryAnalyzer`.
- **Assertions**: Use `org.testng.Assert` in test classes. Use AssertJ `assertThat` in `HamcrestTest` / assumption tests. Do **not** mix assertion libraries within the same test class.
- **Lombok**: `@Builder`, `@Data`, `@AllArgsConstructor` used in model classes. Lombok must be on the annotation processor path — do not remove it from `pom.xml`.
- **No `public` modifier** on test methods unless required (TestNG does not require it).
- **System.out.println** is used intentionally in fixture and listener methods to demonstrate execution order — do not replace with a logger.

## Key TestNG Patterns Used

### Retry with custom annotation
```java
@Test(retryAnalyzer = RetryAnalyzer.class)
@Retries(limit = 3)
public void my_test() { ... }
```

### External data provider
```java
@Test(dataProvider = "myData", dataProviderClass = MyDataProvider.class)
public void my_test(int a, int b, int expected) { ... }
```

### Listener registration
```java
@Listeners(value = MyTestListener.class)
public class MyTest { ... }
```
Or globally in `testng.xml`:
```xml
<listeners>
    <listener class-name="com.oleynik.qa.workshop.testng.listeners.MyTestListener"/>
</listeners>
```

### IExecutionListener — can be registered via @Listeners, testng.xml, or ServiceLoader

`IExecutionListener` extends `ITestNGListener`, so (like most TestNG listeners) it can be
attached with `@Listeners` on a test class, declared in the `<listeners>` block of a
`testng.xml`, or auto-detected via `ServiceLoader`
(`META-INF/services/org.testng.ITestNGListener`). The "XML-only, `@Listeners` is ignored"
restriction applies to `IAnnotationTransformer`, not to `IExecutionListener`.

## Running Tests

```bash
# All tests
mvn clean test

# Single class
mvn clean test -Dtest=AssertTest

# Single method
mvn clean test -Dtest=AssertTest#assert_equals_multiplication_test

# By group
mvn clean test -Dgroups=Smoke,Regression

# Specific XML suite
mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testng1.xml

# Maven Wrapper (no local Maven required)
./mvnw clean test        # Linux/macOS
mvnw.cmd clean test      # Windows
```

## Task Recipes

### Add a new test class

1. Identify the correct package under `src/test/java/com/oleynik/qa/workshop/testng/` (see Key TestNG Patterns above).
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
4. **Note**: `IExecutionListener` can be registered via `@Listeners`, `testng.xml`, or `ServiceLoader` — unlike `IAnnotationTransformer`, which TestNG only honors when declared in `testng.xml`.

### Add a retry test (per-method)

```java
@Test(retryAnalyzer = RetryAnalyzer.class)
@Retries(limit = 3)
void my_retry_test() { ... }
```
`RetryAnalyzer` reads `@Retries` via reflection — no further wiring required.

### Apply retry globally via transformer

Register `RetryTransformer` in `testngretrylistener.xml`:
```xml
<listeners>
    <listener class-name="com.oleynik.qa.workshop.testng.listeners.RetryTransformer"/>
</listeners>
```
Run: `mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testngretrylistener.xml`

## What NOT to Do

- Do not add JUnit 5 annotations (`@org.junit.jupiter.api.Test`) — this project uses TestNG only.
- Do not change `<parallel>methods</parallel>` in `pom.xml` without considering thread-safety of shared state.
- Do not register `IAnnotationTransformer` via `@Listeners` — it is silently ignored; use `testng.xml`. (`IExecutionListener` does not have this restriction.)
- Do not add a `public` access modifier to `@BeforeSuite` / `@AfterSuite` methods unnecessarily — TestNG does not require it.
- Do not introduce static mutable state in test classes — parallel execution (`threadCount=3`) is enabled by default.

