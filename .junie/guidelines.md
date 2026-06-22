# Junie Guidelines

## Project Summary

**TestNG 7 Workshop** — hands-on Java 21 examples covering every major TestNG 7 feature,
from basic assertions to advanced listeners, retry strategies, parallel execution, and XML suite orchestration.  
Companion code for the IT Talk _"JUnit 6 vs TestNG 7"_.

Related project: [JUnit Workshop](https://github.com/a-oleynik/junit-workshop) for side-by-side JUnit comparison.

---

## Stack & Versions

- **Java** 21 LTS
- **TestNG** 7.12.0
- **AssertJ** 3.27.7 (used for assumptions via `assumeThat`)
- **Hamcrest** 3.0 (test scope)
- **Lombok** 1.18.46 (provided scope — annotation processor configured in `pom.xml`)
- **OpenCSV** 5.12.0 (CSV-based data providers)
- **SLF4J** 2.0.17
- **Maven Surefire Plugin** 3.5.6
- **Build**: Maven (wrapper included: `mvnw` / `mvnw.cmd`)

---

## Source Layout

### Production code — `src/main/java/com/oleynik/qa/workshop/testng/`

| Package          | Contents                                                                                                                                                                           |
|------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `annotations/`   | `@Retries(limit)`, `@DataSource(path)` — custom meta-annotations                                                                                                                   |
| `dataproviders/` | `MyDataProvider` — reusable external `@DataProvider` class                                                                                                                         |
| `listeners/`     | `MyTestListener` (`ITestListener`), `MyMethodListener` (`IInvokedMethodListener`), `MyExtendedTestListener` (`TestListenerAdapter`), `RetryTransformer` (`IAnnotationTransformer`) |
| `model/`         | `User`, `MyDoubleWrapper` — Lombok-built domain objects                                                                                                                            |
| `retry/`         | `RetryAnalyzer` — `IRetryAnalyzer` implementation                                                                                                                                  |
| `suites/`        | `MySuiteListener` (`ISuiteListener`), `MyExecutionListener` (`IExecutionListener`)                                                                                                 |
| root             | `Factorial.java`, `Utils.java`                                                                                                                                                     |

### Test code — `src/test/java/com/oleynik/qa/workshop/testng/`

| Package            | Test class(es)                                                                                                  |
|--------------------|-----------------------------------------------------------------------------------------------------------------|
| `general/`         | `AssertTest`, `ExceptionTest`, `FixturesTest`, `HamcrestTest`, `TimeoutTest`, `DisabledTest`, `DescriptionTest` |
| `group/asserts/`   | `SoftAssertTest`                                                                                                |
| `conditional/`     | `AssumeTest`, `AssumeBeforeClassTest`                                                                           |
| `ddt/`             | `StaticDataProviderTest`, `DynamicDataProviderTest`, `OuterDataProviderTest`                                    |
| `nested/`          | `NestedTest`                                                                                                    |
| `grouping/`        | `GroupTest`                                                                                                     |
| `dependencies/`    | `DependenciesTest`                                                                                              |
| `execution/order/` | `ExecutionOrderTest`                                                                                            |
| `suites/`          | `SuiteAnnotationsTest`, `TestAnnotationsTest`, `SuiteListenerTest`, `ExecutionListenerTest`                     |
| `listeners/`       | `TestListenerTest`, `MethodListenerTest`                                                                        |
| `retry/`           | `RetryTest`, `RetryTransformerTest`                                                                             |
| `repeat/`          | `RepeatedTest`                                                                                                  |

### Test resources — `src/test/resources/`

| File                      | Purpose                                                         |
|---------------------------|-----------------------------------------------------------------|
| `numbers.csv`             | CSV data for `DynamicDataProviderTest`, `OuterDataProviderTest` |
| `testng1.xml`             | Include / exclude specific methods per class                    |
| `testng2.xml`             | Run fixed classes in parallel (`thread-count="2"`)              |
| `testnggroups1.xml`       | Groups-of-groups (Smoke + Regression + Fail)                    |
| `testnggroups2.xml`       | Smoke group only                                                |
| `testngretrylistener.xml` | `RetryTransformer` registered as global listener                |
| `testnested.xml`          | Run full package including inner test classes                   |
| `testngsuites.xml`        | `ISuiteListener` + `IExecutionListener` demo                    |

---

## Coding Conventions

### Naming
- Test methods: `snake_case` ending in a noun, e.g. `assert_equals_multiplication_test`
- Test classes: `PascalCase` + `Test` suffix, e.g. `RetryTransformerTest`
- Production classes: `PascalCase`, no `Test` suffix, e.g. `MyTestListener`, `RetryAnalyzer`

### Assertions
- Use `org.testng.Assert` in regular test classes
- Use `AssertJ assertThat(...)` only in `HamcrestTest` / assumption tests
- Do **not** mix assertion libraries within one test class

### Lombok
- `@Builder` / `@Data` / `@AllArgsConstructor` used in model classes
- Do not remove Lombok from the annotation processor path in `pom.xml`

### Thread safety
- Parallel execution is enabled globally (`parallel=methods`, `threadCount=3`)
- Do **not** introduce static mutable state in test classes

### Logging / output
- `System.out.println` is intentional in fixture and listener methods — it demonstrates execution order visually
- Do not replace with a logger in these cases

---

## Important Rules

- This project uses **TestNG only** — do not add JUnit 5 (`org.junit.jupiter`) annotations or imports
- `IExecutionListener` **must** be registered in `testng.xml` — registering it via `@Listeners` on a class is silently ignored
- `ISuiteListener` can be registered either via `@Listeners` or in `testng.xml`
- The `@Retries` annotation is a custom meta-annotation — it is read by `RetryAnalyzer` via reflection, not by TestNG directly
- Do not change `<parallel>methods</parallel>` in `pom.xml` without auditing all test classes for shared mutable state

---

## How to Run

```bash
# All tests (parallel, threadCount=3)
mvn clean test

# Single class
mvn clean test -Dtest=AssertTest

# Single method
mvn clean test -Dtest=AssertTest#assert_equals_multiplication_test

# Pattern matching
mvn clean test -Dtest=AssertTest#assert_equals*

# By group
mvn clean test -Dgroups=Smoke,Regression

# Specific XML suite
mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testngsuites.xml

# Maven Wrapper (no local Maven required)
./mvnw clean test        # Linux / macOS
mvnw.cmd clean test      # Windows

# HTML report
mvn clean surefire-report:report
# → target/site/surefire-report.html
```

---

## Learning Path (for context)

When generating or modifying test examples, follow this conceptual progression:

1. Basic assertions (`AssertTest`)
2. Test lifecycle / fixtures (`FixturesTest`)
3. Exception testing (`ExceptionTest`)
4. Disabling & skipping (`DisabledTest`)
5. Test descriptions (`DescriptionTest`)
6. Hamcrest matchers (`HamcrestTest`)
7. Soft assertions (`SoftAssertTest`)
8. Assumptions (`AssumeTest`)
9. Parameterized tests / `@DataProvider` (`StaticDataProviderTest`)
10. Groups (`GroupTest`)
11. Suite & test-block lifecycle — requires XML suite understanding (`SuiteAnnotationsTest`, `TestAnnotationsTest`)
12. Advanced: listeners, retry strategies, parallel execution, XML suite orchestration

