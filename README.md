# TestNG 7 Workshop Examples

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.9+-blue.svg)](https://maven.apache.org/)
[![TestNG](https://img.shields.io/badge/TestNG-7.12.0-green.svg)](https://testng.org/)
[![AssertJ](https://img.shields.io/badge/AssertJ-3.27.7-yellowgreen.svg)](https://assertj.github.io/doc/)
[![Hamcrest](https://img.shields.io/badge/Hamcrest-3.0-yellowgreen.svg)](https://hamcrest.org/)
[![Lombok](https://img.shields.io/badge/Lombok-1.18.44-red.svg)](https://projectlombok.org/)
[![License](https://img.shields.io/badge/License-MIT-lightgrey.svg)](LICENSE)

> Companion code for the IT Talk **"JUnit 6 vs TestNG 7"**.
> Previous edition: [TestNG vs. JUnit 4 slides](https://www.slideshare.net/oleynikandrey/it-talk-testng-6-vs-junit-4/) · [TestNG vs. JUnit 4 webinar](https://youtu.be/3C-Nu5mkyOQ?t=3189)
>
> **Related projects:**
> - 🧪 [JUnit Workshop](https://github.com/a-oleynik/junit-workshop) — companion JUnit 6 examples to compare side-by-side with this repo
> - 🌐 [Selenium Example](https://github.com/a-oleynik/selenium-example) — real-world Selenium WebDriver framework built on top of TestNG

---

## 📋 Table of Contents

- [Who Is This For?](#-who-is-this-for)
- [Prerequisites](#-prerequisites)
- [Quick Start](#-quick-start)
- [Supported Versions](#-supported-versions)
- [Feature Map](#-feature-map)
- [Learning Path — Beginners](#-learning-path--beginners)
- [Advanced Topics — Path for Senior Engineers](#-advanced-topics--path-for-senior-engineers)
- [Command Examples](#-command-examples)
- [Project Structure](#-project-structure)
- [License](#-license)
- [Additional Resources](#-additional-resources)
- [Useful Links](#-useful-links)

---

## 👥 Who Is This For?

| Audience                                              | What you will get                                                               |
|-------------------------------------------------------|---------------------------------------------------------------------------------|
| **QA engineers** new to TestNG                        | A guided tour of every major feature with runnable examples                     |
| **Java developers** migrating from JUnit 4 / JUnit 5+ | Side-by-side comparison of patterns and idioms                                  |
| **Senior / lead engineers**                           | Deep-dives into listeners, retry strategies, parallel execution, and groups     |
| **Workshop facilitators**                             | A ready-made project you can hand to attendees                                  |

---

## 📦 Prerequisites

| Tool              | Minimum version                   | Notes                                                     |
|-------------------|-----------------------------------|-----------------------------------------------------------|
| **JDK**           | 21 LTS                            |                                                           |
| **Maven**         | 3.9+ *(optional but recommended)* | Not required if using the included Maven Wrapper (`mvnw`) |
| **IDE**           | Any (IntelliJ IDEA recommended)   | Lombok plugin required for IDE support                    |
| **Lombok plugin** | Latest                            | IntelliJ: *Settings → Plugins → Lombok*                   |

> 💡 **Maven Wrapper included** — this project ships with `mvnw` (Linux/macOS) and `mvnw.cmd` (Windows).  
> You can use it instead of a locally installed Maven. The wrapper automatically downloads the correct Maven version on first run.
>
> ```bash
> # Linux / macOS
> ./mvnw clean test
>
> # Windows
> mvnw.cmd clean test
> ```

---

## 🚀 Quick Start

```bash
git clone https://github.com/a-oleynik/testng-workshop.git
cd testng-workshop
mvn clean test
```

---

## 🧩 Supported Versions

| Library              | Version used |
|----------------------|--------------|
| TestNG               | `7.12.0`     |
| AssertJ              | `3.27.7`     |
| Hamcrest             | `3.0`        |
| Lombok               | `1.18.44`    |
| OpenCSV              | `5.12.0`     |
| SLF4J                | `2.0.17`     |
| Java source / target | `21`         |

---

## 🌍 Feature Map

| Package / folder    | Feature demonstrated                                                                      | Test class(es)                                    |
|---------------------|-------------------------------------------------------------------------------------------|---------------------------------------------------|
| `general`           | Basic assertions (`assertEquals`, `assertTrue`, `assertNull`, `assertSame`, …)            | `AssertTest`                                      |
| `general`           | Exception testing (`expectedExceptions`, `expectedExceptionsMessageRegExp`)               | `ExceptionTest`                                   |
| `general`           | Test fixtures (`@BeforeSuite`, `@AfterSuite`, `@BeforeClass`, `@AfterClass`, `@BeforeTest`, `@AfterTest`, `@BeforeMethod`, `@AfterMethod`) | `FixturesTest` |
| `general`           | Hamcrest matchers                                                                         | `HamcrestTest`                                    |
| `general`           | Timeouts (`timeOut` attribute on `@Test`)                                                 | `TimeoutTest`                                     |
| `general`           | Disabling & skipping tests (`enabled = false`, `SkipException`)                           | `DisabledTest`                                    |
| `general`           | Test descriptions (`description` attribute on `@Test`)                                    | `DescriptionTest`                                 |
| `group/asserts`     | Soft assertions (`SoftAssert`)                                                            | `SoftAssertTest`                                  |
| `conditional`       | Assumptions via AssertJ (`assumeThat`) per method                                         | `AssumeTest`                                      |
| `conditional`       | Assumptions in `@BeforeClass` to skip entire class                                        | `AssumeBeforeClassTest`                           |
| `ddt`               | Static inline `@DataProvider`                                                             | `StaticDataProviderTest`                          |
| `ddt`               | Dynamic CSV-file `@DataProvider` (Iterator-based)                                         | `DynamicDataProviderTest`                         |
| `ddt`               | External `@DataProvider` class (`dataProviderClass`)                                      | `OuterDataProviderTest`                           |
| `nested`            | Inner test classes grouped under a parent class                                           | `NestedTest`                                      |
| `grouping`          | Groups (`@Test(groups = …)`), `@BeforeGroups`, `@AfterGroups`                             | `GroupTest`                                       |
| `dependencies`      | Method & group dependencies (`dependsOnMethods`, `dependsOnGroups`)                       | `DependenciesTest`                                |
| `execution/order`   | Test execution ordering via `priority` attribute                                          | `ExecutionOrderTest`                              |
| `suites`            | Suite lifecycle annotations (`@BeforeSuite`, `@AfterSuite`)                               | `SuiteAnnotationsTest`                            |
| `suites`            | Test-block lifecycle annotations (`@BeforeTest`, `@AfterTest`)                            | `TestAnnotationsTest`                             |
| `suites`            | `ISuiteListener` — suite-scoped setup/teardown via listener                               | `SuiteListenerTest`                               |
| `suites`            | `IExecutionListener` — process-wide execution lifecycle (XML registration only)           | `ExecutionListenerTest`                           |
| `listeners`         | `ITestListener` — observe test start, success, failure, skip                              | `TestListenerTest`                                |
| `listeners`         | `IInvokedMethodListener` — intercept before/after every method invocation                 | `MethodListenerTest`                              |
| `retry`             | Retry with `IRetryAnalyzer` + custom `@Retries` annotation                                | `RetryTest`                                       |
| `retry`             | Retry with `IAnnotationTransformer` (`RetryTransformer`) applied globally via XML         | `RetryTransformerTest`                            |
| `repeat`            | Repeated execution (`invocationCount` attribute on `@Test`)                               | `RepeatedTest`                                    |

---

## 🌱 Learning Path — Beginners

Work through these topics in order; each builds on the previous one.

1. **Basic assertions** → `AssertTest`  
   Learn `assertEquals`, `assertTrue`, `assertNull`, `assertSame`, `assertNotSame`, and `fail`.

2. **Test lifecycle** → `FixturesTest`  
   Understand the full TestNG fixture hierarchy: `@BeforeSuite` → `@BeforeTest` → `@BeforeClass` → `@BeforeMethod` (and their `After*` counterparts).

3. **Suite & test-block lifecycle** → `SuiteAnnotationsTest`, `TestAnnotationsTest`  
   See `@BeforeSuite` / `@AfterSuite` run once around the entire suite, and `@BeforeTest` / `@AfterTest` run once per `<test>` block in a `testng.xml` file.

4. **Exception testing** → `ExceptionTest`  
   Use `expectedExceptions` and `expectedExceptionsMessageRegExp` on `@Test` to assert thrown exceptions.

5. **Disabling & skipping tests** → `DisabledTest`  
   Disable tests with `@Test(enabled = false)` or skip them dynamically by throwing `SkipException`.

6. **Test descriptions** → `DescriptionTest`  
   Add human-readable descriptions to tests with `@Test(description = "…")` for better report output.

7. **Hamcrest matchers** → `HamcrestTest`  
   Write expressive assertions with `assertThat`, `equalTo`, `is`, `closeTo`, `both…and`, and more.

8. **Soft assertions** → `SoftAssertTest`  
   Collect all assertion failures with `SoftAssert` before reporting — no early bail-out.

9. **Assumptions** → `AssumeTest`  
   Skip tests dynamically when preconditions aren't met using AssertJ's `assumeThat`.

10. **Parameterized tests** → `StaticDataProviderTest`  
    Drive one test method with multiple data rows using an inline `@DataProvider`.

11. **Groups** → `GroupTest`  
    Mark tests as `Smoke` or `Regression` and run subsets from the command line or via XML suites.

**Run the whole beginner suite:**

```bash
mvn clean test
```

---

## 🎯 Advanced Topics — Path for Senior Engineers

These topics assume familiarity with TestNG basics.

### 1. Suite Lifecycle — Annotations vs. Listeners

`SuiteAnnotationsTest`, `TestAnnotationsTest`, `SuiteListenerTest`, `ExecutionListenerTest` → `suites/` package

TestNG provides three strategies for running code at suite scope, from simplest to most powerful:

| Strategy                       | Class                                           | When to use                                                     |
|--------------------------------|-------------------------------------------------|-----------------------------------------------------------------|
| `@BeforeSuite` / `@AfterSuite` | `SuiteAnnotationsTest`                          | Simplest option; lives inside a test class                      |
| `ISuiteListener`               | `SuiteListenerTest` + `MySuiteListener`         | Infrastructure code outside the test hierarchy; fires per suite |
| `IExecutionListener`           | `ExecutionListenerTest` + `MyExecutionListener` | Process-wide hook across all suites; must be registered in XML  |

**Full fixture execution order:**
```
IExecutionListener.onExecutionStart()       ← once per JVM run
  ISuiteListener.onStart(suite)             ← once per suite
    @BeforeSuite                            ← annotation-based, once per suite
      @BeforeTest                           ← once per <test> block in testng.xml
        @BeforeClass                        ← once per test class
          @BeforeMethod / @Test / @AfterMethod
        @AfterClass
      @AfterTest
    @AfterSuite
  ISuiteListener.onFinish(suite)
IExecutionListener.onExecutionFinish()
```

> **JUnit 5 equivalent:** `@BeforeAll` / `@AfterAll` (annotation-based) or a custom extension
> implementing `BeforeAllCallback` / `AfterAllCallback` (listener-based).

**`@BeforeTest` / `@AfterTest`** (`TestAnnotationsTest`) fire once per `<test>` XML element — coarser than `@BeforeClass` but finer than `@BeforeSuite`. They are TestNG-specific and have no direct JUnit 5 counterpart.

**`IExecutionListener`** cannot be registered via `@Listeners` on a test class — it must be in the `<listeners>` block of a `testng.xml`:

Run the full suites demo:

```bash
mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testngsuites.xml
```

### 2. Groups, `@BeforeGroups` / `@AfterGroups`

`GroupTest` → `grouping/` package  
Assign tests to named groups. Use `@BeforeGroups` and `@AfterGroups` for group-scoped setup/teardown.  
Run groups from the command line:

```bash
mvn clean test -Dgroups=Regression,Smoke
```

Or target a specific XML suite that filters by group:

```bash
# Run only Smoke tests via XML
mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testnggroups2.xml

# Run groups-of-groups (Smoke + Regression + Fail) via XML
mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testnggroups1.xml
```

### 3. Test Dependencies

`DependenciesTest` → `dependencies/` package  
Chain tests so that a downstream test is skipped (not failed) when its upstream dependency fails, using `dependsOnMethods` or `dependsOnGroups`.

### 4. CSV & External Data Providers

`DynamicDataProviderTest`, `OuterDataProviderTest` → `ddt/` package  
- Load test data lazily from CSV files via an `Iterator`-based `@DataProvider`.
- Separate data-provider logic into a dedicated `MyDataProvider` class and reference it with `dataProviderClass`.
- Use the custom `@DataSource(path = "…")` annotation to bind a CSV file path to a test method at runtime.

### 5. Nested Test Classes

`NestedTest` → `nested/` package  
Group related scenarios (`Multiply`, `Divide`, `Add`) as public inner classes inside a parent class. Run them via `testnested.xml`:

```bash
mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testnested.xml
```

### 6. Test Execution Order

`ExecutionOrderTest` → `execution/order/` package  
Control method execution order with the `priority` attribute on `@Test` (lower value = earlier execution). Methods without a priority run before prioritized ones.

### 7. Listeners

`TestListenerTest`, `MethodListenerTest` → `listeners/` package  
- **`ITestListener`** (`MyTestListener`) — react to test start, success, failure, and skip events. Ideal for screenshot capture on failure.  
- **`IInvokedMethodListener`** (`MyMethodListener`) — intercept every method invocation (including `@Before*` / `@After*`).  
- **`TestListenerAdapter`** (`MyExtendedTestListener`) — extend the adapter and override only the callbacks you need.  
Attach listeners declaratively with `@Listeners(value = MyTestListener.class)` or globally via a `testng.xml` `<listeners>` block.

### 8. Retry Strategies

`RetryTest` — `IRetryAnalyzer` + custom `@Retries(limit = N)` annotation applied per test method  
`RetryTransformerTest` — `IAnnotationTransformer` (`RetryTransformer`) injects `RetryAnalyzer` globally for every test in the suite without touching test source code  

Run the transformer-based retry suite:

```bash
mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testngretrylistener.xml
```

### 9. Parallel Execution

Configured globally in `pom.xml` via Surefire:

```xml
<parallel>methods</parallel>
<threadCount>3</threadCount>
```

Tests run concurrently by default. Fine-tune parallelism per suite with `parallel="classes"` or `parallel="tests"` and a custom `thread-count` in any `testng.xml`.

### 10. TestNG XML Suites

All suite XML files live in `src/test/resources/`. They demonstrate:

| File                      | What it shows                                                             |
|---------------------------|---------------------------------------------------------------------------|
| `testng1.xml`             | Include / exclude specific test methods per class                         |
| `testng2.xml`             | Run a fixed set of classes in parallel                                    |
| `testnggroups1.xml`       | Groups-of-groups — combine named groups under one alias                   |
| `testnggroups2.xml`       | Include only the `Smoke` group                                            |
| `testngretrylistener.xml` | Register `RetryTransformer` listener globally                             |
| `testnested.xml`          | Run all tests from a package (including inner classes)                    |
| `testngsuites.xml`        | `ISuiteListener` + `IExecutionListener` + suite lifecycle annotations     |

Run any suite directly:

```bash
mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testng1.xml
```

### 11. Surefire HTML Report Generation

```bash
mvn clean surefire-report:report
# or
mvn clean site
```

> Reports are written to `target/site/surefire-report.html`

---

## 💻 Command Examples

### Run all tests (and generate the reports)

```bash
mvn clean test
```

> Reports are written to:
>
> - Surefire report: `target/surefire-reports/index.html`
> - TestNG emailable report: `target/surefire-reports/emailable-report.html`

### Run a single test class

```bash
mvn clean test -Dtest=AssertTest
```

### Run a single test method

```bash
mvn clean test -Dtest=AssertTest#assert_equals_multiplication_test
```

### Run multiple test classes

```bash
mvn clean test -Dtest=AssertTest,HamcrestTest
```

### Run test methods matching a pattern

```bash
mvn clean test -Dtest=AssertTest#assert_equals*
```

### Run test methods matching multiple patterns

```bash
mvn clean test -Dtest=AssertTest#assert_equals*+assert_boolean*
```

### Run tests by group

```bash
mvn clean test -Dgroups=Regression,Smoke
```

### Run a specific TestNG XML suite

```bash
mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testng1.xml
```

### Compile, test, package, and install to local repo

```bash
mvn clean install
```

### Skip tests (compile + package + install to local repo without running tests)

```bash
mvn clean install -DskipTests
```

### Generate Surefire HTML report (quick)

```bash
mvn clean surefire-report:report
```

> Surefire report is written to:
>
> - Surefire report: `target/reports/surefire.html`

### Enable full debug logging for troubleshooting

```bash
mvn clean test -X
```

---

## 📁 Project Structure

```
src/
├── main/java/com/oleynik/qa/workshop/testng/
│   ├── model/           # Domain model (User, MyDoubleWrapper)
│   ├── annotations/     # Custom annotations (@Retries, @DataSource)
│   ├── dataproviders/   # Reusable data provider (MyDataProvider)
│   ├── listeners/       # ITestListener, IInvokedMethodListener, IAnnotationTransformer
│   ├── suites/          # ISuiteListener (MySuiteListener), IExecutionListener (MyExecutionListener)
│   ├── retry/           # IRetryAnalyzer implementation (RetryAnalyzer)
│   ├── Factorial.java   # Utility class used by data-driven tests
│   └── Utils.java       # Shared test utilities (e.g. waitFor)
└── test/java/com/oleynik/qa/workshop/testng/
    ├── general/         # Core assertions, fixtures, exceptions, descriptions, timeouts
    ├── group/asserts/   # Soft assertions
    ├── conditional/     # Assumptions (AssertJ assumeThat)
    ├── ddt/             # Data-driven tests (@DataProvider, CSV, external provider)
    ├── nested/          # Inner-class test grouping
    ├── grouping/        # TestNG groups (@Test(groups = …))
    ├── dependencies/    # Test dependencies (dependsOnMethods / dependsOnGroups)
    ├── execution/order/ # Test execution ordering (priority)
    ├── listeners/       # Tests demonstrating listener hooks
    ├── suites/          # Suite lifecycle: @BeforeSuite/@AfterSuite, @BeforeTest/@AfterTest,
    │                    #   ISuiteListener, IExecutionListener
    ├── retry/           # Retry strategies (IRetryAnalyzer, IAnnotationTransformer)
    └── repeat/          # Repeated execution (invocationCount)
```

---

## 📝 License

This project is licensed under the MIT License — see the [LICENSE](LICENSE) file for details.

---

## 📚 Additional Resources

- [TestNG Documentation](https://testng.org/doc/)
- [TestNG GitHub](https://github.com/testng-team/testng)
- [AssertJ Documentation](https://assertj.github.io/doc/)
- [Hamcrest Tutorial](https://hamcrest.org/JavaHamcrest/tutorial)
- [Lombok Features](https://projectlombok.org/features/)
- [OpenCSV Documentation](https://opencsv.sourceforge.net/)
- [Maven Surefire Plugin](https://maven.apache.org/surefire/maven-surefire-plugin/)
- [Maven Surefire Report Plugin](https://maven.apache.org/surefire/maven-surefire-report-plugin/)
- [JUnit Workshop](https://github.com/a-oleynik/junit-workshop) — companion JUnit 6 examples
- [Selenium Example](https://github.com/a-oleynik/selenium-example) — real-world Selenium framework using TestNG
- [TestNG XML Is a Legacy Concept: Here's What Modern Test Suites Should Look Like](https://medium.com/@andrei.oleynik/testng-xml-is-a-legacy-concept-heres-what-modern-test-suites-should-look-like-bd5cb380db61) — article on modern TestNG suite configuration

---

## 🔗 Useful Links

- **Java Download:** https://www.oracle.com/java/technologies/downloads/
- **Maven Download:** https://maven.apache.org/download.cgi
- **TestNG Releases:** https://github.com/testng-team/testng/releases
- **Lombok Download:** https://projectlombok.org/download
- **IntelliJ Lombok Plugin:** https://plugins.jetbrains.com/plugin/6317-lombok
