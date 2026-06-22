# AGENTS.md

Guidance for AI agents (OpenAI Codex, Claude Code, Gemini CLI, and similar tools) working in this repository.

---

## What this repository is

**TestNG 7 Workshop** — a Java 21 Maven project demonstrating every major TestNG 7 feature.  
It is the companion code for the IT Talk _"JUnit 6 vs TestNG 7"_.

This is a **test-only project**: there is no deployable application.  
Production code (`src/main/`) contains only shared utilities, listeners, data providers, model classes, and retry infrastructure used by the tests in `src/test/`.

---

## Environment setup

| Requirement | Version  | Notes                                                   |
|-------------|----------|---------------------------------------------------------|
| Java (JDK)  | 21 LTS   | Must be on `PATH` / `JAVA_HOME`                         |
| Maven       | 3.9+     | Optional — Maven Wrapper (`mvnw` / `mvnw.cmd`) included |

No external services, databases, or containers are required.

---

## How to build and verify

```bash
# Compile everything
mvn clean compile

# Run all tests (parallel, threadCount=3)
mvn clean test

# Run a single class
mvn clean test -Dtest=AssertTest

# Run a single method
mvn clean test -Dtest=AssertTest#assert_equals_multiplication_test

# Run by group
mvn clean test -Dgroups=Smoke,Regression

# Run a specific XML suite
mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testng1.xml

# Generate HTML report
mvn clean surefire-report:report
# → target/site/surefire-report.html

# Maven Wrapper (if Maven is not installed locally)
./mvnw clean test        # Linux / macOS
mvnw.cmd clean test      # Windows
```

**Always run `mvn clean test` after any code change to verify nothing is broken.**

---

## Project layout

```
src/
├── main/java/com/oleynik/qa/workshop/testng/
│   ├── annotations/     # @Retries, @DataSource
│   ├── dataproviders/   # MyDataProvider
│   ├── listeners/       # MyTestListener, MyMethodListener, MyExtendedTestListener, RetryTransformer
│   ├── model/           # User, MyDoubleWrapper (Lombok)
│   ├── retry/           # RetryAnalyzer
│   ├── suites/          # MySuiteListener, MyExecutionListener
│   ├── Factorial.java
│   └── Utils.java
└── test/java/com/oleynik/qa/workshop/testng/
    ├── general/         # AssertTest, ExceptionTest, FixturesTest, HamcrestTest,
    │                    # TimeoutTest, DisabledTest, DescriptionTest
    ├── group/asserts/   # SoftAssertTest
    ├── conditional/     # AssumeTest, AssumeBeforeClassTest
    ├── ddt/             # StaticDataProviderTest, DynamicDataProviderTest, OuterDataProviderTest
    ├── nested/          # NestedTest
    ├── grouping/        # GroupTest
    ├── dependencies/    # DependenciesTest
    ├── execution/order/ # ExecutionOrderTest
    ├── suites/          # SuiteAnnotationsTest, TestAnnotationsTest,
    │                    # SuiteListenerTest, ExecutionListenerTest
    ├── listeners/       # TestListenerTest, MethodListenerTest
    ├── retry/           # RetryTest, RetryTransformerTest
    └── repeat/          # RepeatedTest

src/test/resources/
    numbers.csv              # CSV data for data-driven tests
    testng1.xml              # Include/exclude specific methods
    testng2.xml              # Run fixed classes in parallel
    testnggroups1.xml        # Groups-of-groups
    testnggroups2.xml        # Smoke group only
    testngretrylistener.xml  # RetryTransformer as global listener
    testnested.xml           # Run full package with inner classes
    testngsuites.xml         # ISuiteListener + IExecutionListener demo
```

---

## Coding conventions

### Naming
- Test method names: `snake_case` ending with `_test`, e.g. `assert_equals_multiplication_test`
- Test class names: `PascalCase` + `Test` suffix, e.g. `AssertTest`, `RetryTransformerTest`
- Production classes: `PascalCase`, no `Test` suffix, e.g. `MyTestListener`, `RetryAnalyzer`

### Assertions
- Use `org.testng.Assert` in regular test classes (`assertEquals`, `assertTrue`, `assertNull`, …)
- Use AssertJ `assertThat(...)` only in `HamcrestTest` and assumption tests
- Do **not** mix assertion libraries within the same test class

### Access modifiers
- Test methods do not need `public` — TestNG does not require it
- `@BeforeSuite` / `@AfterSuite` methods do not need `public`

### Output
- `System.out.println` in fixture and listener methods is **intentional** — it demonstrates execution order
- Do not replace these with a logger

### Lombok
- `@Builder`, `@Data`, `@AllArgsConstructor` are used in model classes
- Do not remove Lombok from `pom.xml` or from the compiler annotation processor path

---

## Important TestNG rules

| Rule                                                               | Why                                                                   |
|--------------------------------------------------------------------|-----------------------------------------------------------------------|
| Do **not** use `@org.junit.jupiter.api.Test`                       | This project is TestNG-only                                           |
| `IExecutionListener` must be registered in `testng.xml`            | Registering it via `@Listeners` is silently ignored by TestNG         |
| `ISuiteListener` can be registered either way                      | Via `@Listeners` on a class or in `testng.xml` `<listeners>` block    |
| `@Retries` is a custom annotation                                  | It is read by `RetryAnalyzer` via reflection — not natively by TestNG |
| Do not add static mutable state to test classes                    | `parallel=methods`, `threadCount=3` is active by default in `pom.xml` |
| Do not modify `<parallel>` in `pom.xml` without auditing all tests | Can cause race conditions on shared state                             |

---

## XML suite listener registration example

```xml
<suite name="MySuite" parallel="none">
    <listeners>
        <listener class-name="com.oleynik.qa.workshop.testng.suites.MySuiteListener"/>
        <listener class-name="com.oleynik.qa.workshop.testng.suites.MyExecutionListener"/>
    </listeners>
    <test name="My Test">
        <classes>
            <class name="com.oleynik.qa.workshop.testng.suites.SuiteAnnotationsTest"/>
        </classes>
    </test>
</suite>
```

---

## Common patterns

### Retry with custom annotation
```java
@Test(retryAnalyzer = RetryAnalyzer.class)
@Retries(limit = 3)
void retry_equals_division_test() {
    Assert.assertEquals(10 / 5.0, 2.0, 0);
}
```

### External data provider
```java
@Test(dataProvider = "myData", dataProviderClass = MyDataProvider.class)
void factorial_test(int input, long expected) {
    Assert.assertEquals(Factorial.compute(input), expected);
}
```

### Soft assertions
```java
void soft_assert_test() {
    SoftAssert soft = new SoftAssert();
    soft.assertEquals(2 * 5, 10);
    soft.assertTrue(true);
    soft.assertAll();   // reports all failures at once
}
```

### Listener via annotation
```java
@Listeners(value = MyTestListener.class)
public class TestListenerTest { ... }
```

---

## Feature index (for navigation)

| Feature                 | Package           | Key class(es)                                   |
|-------------------------|-------------------|-------------------------------------------------|
| Basic assertions        | `general`         | `AssertTest`                                    |
| Fixtures / lifecycle    | `general`         | `FixturesTest`                                  |
| Exception testing       | `general`         | `ExceptionTest`                                 |
| Timeouts                | `general`         | `TimeoutTest`                                   |
| Disabling / skipping    | `general`         | `DisabledTest`                                  |
| Hamcrest matchers       | `general`         | `HamcrestTest`                                  |
| Soft assertions         | `group/asserts`   | `SoftAssertTest`                                |
| Assumptions (AssertJ)   | `conditional`     | `AssumeTest`, `AssumeBeforeClassTest`           |
| Data providers (static) | `ddt`             | `StaticDataProviderTest`                        |
| Data providers (CSV)    | `ddt`             | `DynamicDataProviderTest`                       |
| External data provider  | `ddt`             | `OuterDataProviderTest`                         |
| Nested test classes     | `nested`          | `NestedTest`                                    |
| Groups                  | `grouping`        | `GroupTest`                                     |
| Test dependencies       | `dependencies`    | `DependenciesTest`                              |
| Execution ordering      | `execution/order` | `ExecutionOrderTest`                            |
| Suite annotations       | `suites`          | `SuiteAnnotationsTest`                          |
| Test-block annotations  | `suites`          | `TestAnnotationsTest`                           |
| ISuiteListener          | `suites`          | `SuiteListenerTest` + `MySuiteListener`         |
| IExecutionListener      | `suites`          | `ExecutionListenerTest` + `MyExecutionListener` |
| ITestListener           | `listeners`       | `TestListenerTest` + `MyTestListener`           |
| IInvokedMethodListener  | `listeners`       | `MethodListenerTest` + `MyMethodListener`       |
| TestListenerAdapter     | `listeners`       | `TestListenerTest` + `MyExtendedTestListener`   |
| Retry (IRetryAnalyzer)  | `retry`           | `RetryTest` + `RetryAnalyzer`                   |
| Retry (transformer)     | `retry`           | `RetryTransformerTest` + `RetryTransformer`     |
| Repeated execution      | `repeat`          | `RepeatedTest`                                  |

