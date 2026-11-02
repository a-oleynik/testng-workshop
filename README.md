# TestNG 7 Workshop Examples
[![Java CI with Maven](https://github.com/a-oleynik/testng-workshop/actions/workflows/maven.yml/badge.svg)](https://github.com/a-oleynik/testng-workshop/actions/workflows/maven.yml)
[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.9+-blue.svg)](https://maven.apache.org/)
[![Gradle](https://img.shields.io/badge/Gradle-9.6.0-02303A.svg)](https://gradle.org/)
[![TestNG](https://img.shields.io/badge/TestNG-7.12.0-green.svg)](https://testng.org/)
[![AssertJ](https://img.shields.io/badge/AssertJ-3.27.7-yellowgreen.svg)](https://assertj.github.io/doc/)
[![Hamcrest](https://img.shields.io/badge/Hamcrest-3.0-yellowgreen.svg)](https://hamcrest.org/)
[![Lombok](https://img.shields.io/badge/Lombok-1.18.48-red.svg)](https://projectlombok.org/)
[![License](https://img.shields.io/badge/License-MIT-lightgrey.svg)](LICENSE)

A hands-on Java testing workshop with runnable examples using TestNG 7.

Learn TestNG from scratch, explore advanced features, and compare TestNG with JUnit. Includes Maven and Gradle support, step-by-step learning paths, and practical examples for articles, workshops, tech talks, and self-study.

> Originally created as companion code for the IT Talk **"JUnit 6 vs TestNG 7"**.
> Previous edition: [TestNG vs. JUnit 4 slides](https://www.slideshare.net/oleynikandrey/it-talk-testng-6-vs-junit-4/) · [TestNG vs. JUnit 4 webinar](https://youtu.be/3C-Nu5mkyOQ?t=3207)
>
> **Related projects:**
> - 🧪 [JUnit Workshop](https://github.com/a-oleynik/junit-workshop) — companion JUnit 6 examples to compare side-by-side with this repo
> - 🌐 [Selenium Example](https://github.com/a-oleynik/selenium-example) — real-world Selenium WebDriver framework built on top of TestNG

---

## 📋 Table of Contents

- [Why this repository?](#-why-this-repository)
- [Who Is This For?](#-who-is-this-for)
- [Quick Start](#-quick-start)
- [Prerequisites](#-prerequisites)
- [Project Structure](#-project-structure)
- [Feature Map](#-feature-map)
- [Beginner Learning Path](#-beginner-learning-path)
- [Advanced Learning Path](#-advanced-learning-path)
- [Command Examples](#-command-examples)
- [Supported Versions](#-supported-versions)
- [CI / CD](#-ci--cd)
- [AI Assistant Support](#-ai-assistant-support)
- [Additional Resources](#-additional-resources)
- [Useful Links](#-useful-links)
- [Found it useful?](#-found-it-useful)
- [License](#-license)

---

## 🤔 Why this repository?

TestNG is more than `@Test`, assertions, and `@DataProvider`.

This project covers fundamental and advanced TestNG 7 features with practical, runnable Java examples you can clone, execute, and adapt to your own projects.

Use this repository if you want to:

- **learn TestNG from scratch** with a structured, step-by-step learning path
- **explore runnable examples** that demonstrate TestNG features in practice
- **master advanced features** — listeners, retry strategies, parallel execution, groups, dependencies, and data-driven testing
- **study automated testing patterns in Java** — soft assertions, conditional execution, parameterized tests, and more
- **understand test and suite orchestration** — lifecycle annotations (`@BeforeSuite`, `@BeforeTest`, `@BeforeClass`), XML suites, listeners, and execution hooks
- **work with Maven and Gradle** — run the same test examples using either build tool
- **compare TestNG and JUnit** patterns and idioms side-by-side with the companion [JUnit Workshop](https://github.com/a-oleynik/junit-workshop)
- **use it as material** for workshops, tech talks, onboarding sessions, and self-study

[⬆ Back to Table of Contents](#-table-of-contents)

---

## 👥 Who Is This For?

| Audience                                              | What you will get                                                               |
|-------------------------------------------------------|---------------------------------------------------------------------------------|
| **QA engineers** new to TestNG                        | A guided tour of every major feature with runnable examples                     |
| **Java developers** migrating from JUnit 4 / JUnit 5+ | Side-by-side comparison of patterns and idioms                                  |
| **Senior / lead engineers**                           | Deep-dives into listeners, retry strategies, parallel execution, and groups     |
| **Workshop facilitators**                             | A ready-made project you can hand to attendees                                  |

[⬆ Back to Table of Contents](#-table-of-contents)

---

## 🚀 Quick Start

This checkout supports **Maven and Gradle independently**, using the same
`src/main/java`, `src/test/java`, and `src/test/resources` directories.

```bash
git clone https://github.com/a-oleynik/testng-workshop.git
cd testng-workshop

# Maven
./mvnw clean test

# Gradle
./gradlew clean test
```

On Windows PowerShell, use `.\mvnw.cmd clean test` or `.\gradlew.bat clean test`.
Locally installed tools also work: `mvn clean test` or `gradle clean test`.

### Import into an IDE

Import `pom.xml` for Maven or `settings.gradle` / `build.gradle` for Gradle.
In IntelliJ IDEA, choose one build model for the current IDE project when both
are detected, as in the companion JUnit Workshop.

[⬆ Back to Table of Contents](#-table-of-contents)

---

## 📦 Prerequisites

> 💡 **Need help setting up your environment?**  
> Check the comprehensive [Java, Maven & Gradle Setup Guide (Windows, macOS, Ubuntu)](https://medium.com/@andrei.oleynik/how-to-install-and-set-up-java-on-windows-macos-and-ubuntu-jdk-maven-and-gradle-728a732dd123) covering JDK installation, `JAVA_HOME` configuration, build tools setup, and troubleshooting.

| Tool              | Minimum version                   | Notes                                                         |
|-------------------|-----------------------------------|---------------------------------------------------------------|
| **JDK**           | 21 LTS                            |                                                               |
| **Maven**         | 3.9+ *(optional but recommended)* | Not required if using the included Maven Wrapper (`mvnw`)     |
| **Gradle**        | 9.6.0 *(optional)*                | Not required if using the included Gradle Wrapper (`gradlew`) |
| **Git**           | 2.x+ *(optional)*                 | For cloning and managing repository revisions                 |
| **IDE**           | Any (IntelliJ IDEA recommended)   | Lombok plugin required for IDE support                        |
| **Lombok plugin** | Latest                            | IntelliJ: *Settings → Plugins → Lombok*                       |

> 💡 **Maven and Gradle Wrappers included** — no local build-tool installation is required.
> Each wrapper downloads its pinned version on first run (internet access required):
> Maven 3.9.12 or Gradle 9.6.0. Both builds require JDK 21 on `PATH` / `JAVA_HOME`.
>
> ```bash
> # Linux / macOS (or Git Bash on Windows)
> ./mvnw clean test
> ./gradlew clean test
>
> # Windows PowerShell
> .\mvnw.cmd clean test
> .\gradlew.bat clean test
> ```

[⬆ Back to Table of Contents](#-table-of-contents)

---

## 📁 Project Structure

The tree shows the current checkout, with Java files grouped by package.
Generated directories are ignored by Git; their contents depend on the build
commands you run. The [Feature Map](#-feature-map) lists the test classes for each topic.

```text
.github/
├── workflows/
│   └── maven.yml                    # GitHub Actions CI — all tests and optional group selection
└── copilot-instructions.md          # GitHub Copilot workspace instructions
.gradle/                             # Generated local Gradle cache
.junie/
└── guidelines.md                    # JetBrains Junie project guidelines
.mvn/
└── wrapper/
    └── maven-wrapper.properties     # Maven Wrapper configuration — Maven 3.9.12
build/                               # Generated Gradle output
├── classes/java/
│   ├── main/                        # Compiled shared utilities, models, and listeners
│   └── test/                        # Compiled tests
├── libs/                            # Workshop utilities JAR after build
├── reports/tests/
│   ├── suiteTest/
│   │   └── index.html               # HTML report for the selected XML suite
│   └── test/
│       └── index.html               # HTML report for ordinary test discovery
├── resources/test/                  # Copied test resources
└── test-results/
    ├── suiteTest/                   # XML results for suiteTest
    └── test/                        # XML results for test
gradle/
└── wrapper/
    ├── gradle-wrapper.jar           # Committed Gradle Wrapper bootstrap JAR
    └── gradle-wrapper.properties    # Gradle Wrapper configuration — Gradle 9.6.0
src/
├── main/java/com/oleynik/qa/workshop/testng/
│   ├── annotations/                 # Custom annotations (@Retries, @DataSource)
│   ├── dataproviders/               # Reusable data provider (MyDataProvider)
│   ├── listeners/                   # ITestListener, IInvokedMethodListener, IAnnotationTransformer (RetryTransformer)
│   ├── model/                       # Domain models (MyDoubleWrapper, ShoppingCart, User)
│   ├── retry/                       # IRetryAnalyzer implementation (RetryAnalyzer)
│   ├── suites/                      # ISuiteListener (MySuiteListener), IExecutionListener (MyExecutionListener)
│   ├── Factorial.java               # Utility class used by data-driven tests
│   └── Utils.java                   # Shared test utilities (e.g. waitFor)
└── test/
    ├── java/com/oleynik/qa/workshop/testng/
    │   ├── conditional/             # Assumptions (AssertJ assumeThat)
    │   ├── ddt/                     # Data-driven tests (@DataProvider, CSV, external provider)
    │   ├── dependencies/            # Test dependencies (dependsOnMethods / dependsOnGroups)
    │   ├── execution/order/         # Test execution ordering (priority)
    │   ├── fixtures/                # Fresh / Shared Fixture; Inline / Implicit Setup
    │   ├── general/                 # Core assertions, lifecycle, exceptions, descriptions, timeouts
    │   ├── group/asserts/           # Soft assertions (SoftAssertTest)
    │   ├── grouping/                # TestNG groups (@Test(groups = …))
    │   ├── listeners/               # Tests demonstrating listener hooks
    │   ├── nested/                  # Inner-class test grouping
    │   ├── repeat/                  # Repeated execution (invocationCount)
    │   ├── retry/                   # Retry strategies (IRetryAnalyzer, IAnnotationTransformer)
    │   └── suites/                  # @BeforeSuite/@AfterSuite, @BeforeTest/@AfterTest, ISuiteListener, IExecutionListener
    └── resources/
        ├── numbers.csv              # Input / expected factorial values for CSV data providers
        ├── testnested.xml           # Discover nested tests by package
        ├── testng1.xml              # Include / exclude specific test methods
        ├── testng2.xml              # Run fixed classes in parallel
        ├── testnggroups1.xml        # Groups-of-groups
        ├── testnggroups2.xml        # Smoke group only
        ├── testngretrylistener.xml  # Register RetryTransformer globally for this suite
        └── testngsuites.xml         # Suite / execution listeners and lifecycle annotations
target/                              # Generated Maven output
├── classes/                         # Compiled shared utilities, models, and listeners
├── reports/
│   └── surefire.html                # Standalone surefire-report:report output
├── site/                            # Maven project website after site
├── surefire-reports/
│   ├── emailable-report.html        # TestNG emailable report
│   ├── index.html                   # TestNG HTML report after Maven test
│   ├── TEST-*.xml                   # JUnit-compatible XML results for CI
│   └── testng-results.xml           # Native TestNG results
└── test-classes/                    # Compiled tests and copied test resources

.gitattributes                       # Wrapper script line endings
.gitignore                           # Generated output, caches, and IDE exclusions
AGENTS.md                            # AI agent instructions and verification commands
build.gradle                         # Java 21, dependencies, test, suiteTest, and local publication
gradlew                              # Gradle Wrapper for Unix
gradlew.bat                          # Gradle Wrapper for Windows
LICENSE                              # MIT license
mvnw                                 # Maven Wrapper for Unix
mvnw.cmd                             # Maven Wrapper for Windows
pom.xml                              # Maven dependencies, Lombok processor, and Surefire configuration
README.md                            # Project documentation and run commands
settings.gradle                      # Gradle project name
```

[⬆ Back to Table of Contents](#-table-of-contents)

---

## 🌍 Feature Map

> 💡 **New to TestNG?** Follow the [Learning Path](#-beginner-learning-path) for a recommended study order.

| Package / folder  | Feature demonstrated                                                                                                                        | Test class(es)                                                  |
|-------------------|---------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------|
| `general`         | Basic assertions (`assertEquals`, `assertTrue`, `assertNull`, `assertSame`, …)                                                              | `AssertTest`                                                    |
| `general`         | Exception testing (`expectedExceptions`, `expectedExceptionsMessageRegExp`)                                                                 | `ExceptionTest`                                                 |
| `general`         | Test lifecycle (`@BeforeSuite`, `@AfterSuite`, `@BeforeClass`, `@AfterClass`, `@BeforeTest`, `@AfterTest`, `@BeforeMethod`, `@AfterMethod`) | `LifecycleTest`                                                 |
| `fixtures`        | Fresh Fixture, Shared Fixture, Inline Setup, and Implicit Setup                                                                             | `InlineFixtureTest`, `ImplicitFixtureTest`, `SharedFixtureTest` |
| `general`         | Hamcrest matchers                                                                                                                           | `HamcrestTest`                                                  |
| `general`         | Timeouts (`timeOut` attribute on `@Test`)                                                                                                   | `TimeoutTest`                                                   |
| `general`         | Disabling & skipping tests (`enabled = false`, `SkipException`)                                                                             | `DisabledTest`                                                  |
| `general`         | Test descriptions (`description` attribute on `@Test`)                                                                                      | `DescriptionTest`                                               |
| `group/asserts`   | Soft assertions (`SoftAssert`)                                                                                                              | `SoftAssertTest`                                                |
| `conditional`     | Assumptions via AssertJ (`assumeThat`) per method                                                                                           | `AssumeTest`                                                    |
| `conditional`     | Assumptions in `@BeforeClass` to skip entire class                                                                                          | `AssumeBeforeClassTest`                                         |
| `ddt`             | Static inline `@DataProvider`                                                                                                               | `StaticDataProviderTest`                                        |
| `ddt`             | Dynamic CSV-file `@DataProvider` (Iterator-based)                                                                                           | `DynamicDataProviderTest`                                       |
| `ddt`             | External `@DataProvider` class (`dataProviderClass`)                                                                                        | `OuterDataProviderTest`                                         |
| `nested`          | Inner test classes grouped under a parent class                                                                                             | `NestedTest`                                                    |
| `grouping`        | Groups (`@Test(groups = …)`), `@BeforeGroups`, `@AfterGroups`                                                                               | `GroupTest`                                                     |
| `dependencies`    | Method & group dependencies (`dependsOnMethods`, `dependsOnGroups`)                                                                         | `DependenciesTest`                                              |
| `execution/order` | Test execution ordering via `priority` attribute                                                                                            | `ExecutionOrderTest`                                            |
| `suites`          | Suite lifecycle annotations (`@BeforeSuite`, `@AfterSuite`)                                                                                 | `SuiteAnnotationsTest`                                          |
| `suites`          | Test-block lifecycle annotations (`@BeforeTest`, `@AfterTest`)                                                                              | `TestAnnotationsTest`                                           |
| `suites`          | `ISuiteListener` — suite-scoped setup/teardown via listener                                                                                 | `SuiteListenerTest`                                             |
| `suites`          | `IExecutionListener` — execution-wide lifecycle (registrable via `@Listeners`, XML, or `ServiceLoader`)                                     | `ExecutionListenerTest`                                         |
| `listeners`       | `ITestListener` — observe test start, success, failure, skip                                                                                | `TestListenerTest`                                              |
| `listeners`       | `IInvokedMethodListener` — intercept before/after every method invocation                                                                   | `MethodListenerTest`                                            |
| `listeners`       | `TestListenerAdapter` — extend the adapter and override only the callbacks you need                                                         | `TestListenerTest`                                              |
| `retry`           | Retry with `IRetryAnalyzer` + custom `@Retries` annotation                                                                                  | `RetryTest`                                                     |
| `retry`           | Retry with `IAnnotationTransformer` (`RetryTransformer`) applied globally via XML                                                           | `RetryTransformerTest`                                          |
| `repeat`          | Repeated execution (`invocationCount` attribute on `@Test`)                                                                                 | `RepeatedTest`                                                  |

[⬆ Back to Table of Contents](#-table-of-contents)

---

## 🌱 Beginner Learning Path

Work through these topics in order; each builds on the previous one.

### 1. Basic assertions

`AssertTest`

Learn `assertEquals`, `assertTrue`, `assertNull`, `assertSame`, `assertNotSame`, and `fail`.

### 2. Test lifecycle

[`LifecycleTest`](src/test/java/com/oleynik/qa/workshop/testng/general/LifecycleTest.java)

Understand the scopes of TestNG configuration methods: `@BeforeSuite` → `@BeforeTest` → `@BeforeClass` → `@BeforeMethod`, with the corresponding `@After*` callbacks. `@BeforeTest` belongs to an XML `<test>` block; `@BeforeMethod` runs before each test method.

This example logs lifecycle callbacks. The fixture examples in the next topic show the state those callbacks can prepare. `LifecycleTest` runs its test methods in one thread to make the trace easier to follow; the rest of the workshop keeps its parallel defaults.

```bash
./mvnw clean test -Dtest=LifecycleTest
./gradlew clean test --tests "LifecycleTest"
```

### 3. Fixtures

[`InlineFixtureTest`](src/test/java/com/oleynik/qa/workshop/testng/fixtures/InlineFixtureTest.java),
[`ImplicitFixtureTest`](src/test/java/com/oleynik/qa/workshop/testng/fixtures/ImplicitFixtureTest.java),
[`SharedFixtureTest`](src/test/java/com/oleynik/qa/workshop/testng/fixtures/SharedFixtureTest.java)

A **fixture** is the prepared state, data, objects, or resources needed by a test.
Lifecycle callbacks such as `@BeforeMethod` prepare it; the callbacks are the setup mechanism.
The examples use the same small [`ShoppingCart`](src/main/java/com/oleynik/qa/workshop/testng/model/ShoppingCart.java) and cart scenarios as the companion JUnit Workshop. Prices and totals use integer minor currency units.

| Concept            | What it describes                                          | Example                                                                                            |
|--------------------|------------------------------------------------------------|----------------------------------------------------------------------------------------------------|
| **Fresh Fixture**  | State created separately for each test.                    | Every test gets a new empty `ShoppingCart`.                                                        |
| **Shared Fixture** | A fixture, or part of it, reused by several tests.         | `SharedFixtureTest` creates one immutable price catalog per test-class instance in `@BeforeClass`. |
| **Inline Setup**   | Preparation written directly inside the test method.       | `InlineFixtureTest` constructs the cart in each test.                                              |
| **Implicit Setup** | Common preparation invoked automatically before each test. | `ImplicitFixtureTest` and `SharedFixtureTest` create their carts in `@BeforeMethod`.               |

Fresh/Shared Fixture describes reuse; Inline/Implicit Setup describes how preparation is invoked.
The first two classes compare the same cart scenarios with different setup locations.
Their scenario-specific prices and quantities stay visible in each test. All three examples
assert an initial cart total of zero and then expected totals of 400 or 450.
The shared example combines reusable read-only reference data with a fresh mutable cart,
so tests do not depend on each other's changes or execution order.

TestNG reuses a test-class instance across its methods. With the workshop's `parallel=methods` default, replacing a cart field in `@BeforeMethod` needs isolation.
`ImplicitFixtureTest` and `SharedFixtureTest` use class-level `@Test(singleThreaded = true)`
so their test methods run in one thread; `@BeforeMethod` still creates a fresh cart for each test.
The global `methods/3` configuration is unchanged.

These in-memory fixtures need no explicit teardown; external resources may need cleanup in
the matching `@After*` callback.

```bash
./mvnw clean test -Dtest=InlineFixtureTest,ImplicitFixtureTest,SharedFixtureTest
./gradlew clean test --tests "InlineFixtureTest" --tests "ImplicitFixtureTest" --tests "SharedFixtureTest"
```

### 4. Exception testing

`ExceptionTest`

Use `expectedExceptions` and `expectedExceptionsMessageRegExp` on `@Test` to assert thrown exceptions.

### 5. Disabling & skipping tests

`DisabledTest`

Disable tests with `@Test(enabled = false)` or skip them dynamically by throwing `SkipException`.

### 6. Test descriptions

`DescriptionTest`

Add human-readable descriptions to tests with `@Test(description = "…")` for better report output.

### 7. Soft assertions

`SoftAssertTest`

Collect all assertion failures with `SoftAssert` before reporting — no early bail-out.

### 8. Assumptions

`AssumeTest`

Skip tests dynamically when preconditions aren't met using AssertJ's `assumeThat`.

### 9. Parameterized tests

`StaticDataProviderTest`

Drive one test method with multiple data rows using an inline `@DataProvider`.

### 10. Groups

`GroupTest`

Mark tests as `Smoke` or `Regression` and run subsets from the command line or via XML suites.

### 11. Suite & test-block lifecycle

`SuiteAnnotationsTest`, `TestAnnotationsTest`

See `@BeforeSuite` / `@AfterSuite` run once around the entire suite, and `@BeforeTest` / `@AfterTest` run once per `<test>` block in a `testng.xml` file. Having seen XML suites in step 10, the distinction between `@BeforeTest` and `@BeforeClass` now makes full sense — and this topic bridges directly into the Advanced Learning Path section.

### 12. Surefire HTML Report Generation

```bash
./mvnw clean surefire-report:report
./gradlew clean test
# or
./mvnw clean site
./gradlew clean test
```

> Maven Surefire Report output: `target/reports/surefire.html` for `surefire-report:report`
> (current standalone-plugin default). Maven Site uses `target/site/`;
> Gradle HTML test reports use `build/reports/tests/test/index.html`.

For this test-only project, `./gradlew clean test` provides the test-report equivalent
of either Maven command above. It does not generate the Maven project website.

**Run all workshop tests:**

```bash
./mvnw clean test
./gradlew clean test
```

[⬆ Back to Table of Contents](#-table-of-contents)

---

## 🎯 Advanced Learning Path

These topics assume familiarity with TestNG basics.

### 1. Suite Lifecycle — Annotations vs. Listeners

`SuiteAnnotationsTest`, `TestAnnotationsTest`, `SuiteListenerTest`, `ExecutionListenerTest` → `suites/` package

TestNG provides callbacks at suite scope and at the enclosing execution scope:

| Strategy                       | Class                                           | When to use                                                                                                   |
|--------------------------------|-------------------------------------------------|---------------------------------------------------------------------------------------------------------------|
| `@BeforeSuite` / `@AfterSuite` | `SuiteAnnotationsTest`                          | Simplest option; lives inside a test class                                                                    |
| `ISuiteListener`               | `SuiteListenerTest` + `MySuiteListener`         | Infrastructure code outside the test hierarchy; fires per suite                                               |
| `IExecutionListener`           | `ExecutionListenerTest` + `MyExecutionListener` | Fires once per TestNG execution, across all its suites; registrable via `@Listeners`, XML, or `ServiceLoader` |

**Lifecycle callback order:**
```
IExecutionListener.onExecutionStart()       ← once per TestNG execution
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

> **JUnit comparison:** JUnit Platform Suite API provides `@BeforeSuite` / `@AfterSuite` for a suite entry point. Jupiter's `@BeforeAll` / `@AfterAll` and `BeforeAllCallback` / `AfterAllCallback` have class-level scope; placing them in a base class or registering an extension through ServiceLoader does not make them suite-wide.

**`@BeforeTest` / `@AfterTest`** (`TestAnnotationsTest`) fire once per `<test>` XML element — coarser than `@BeforeClass` but finer than `@BeforeSuite`. They are TestNG-specific and have no direct JUnit 5 counterpart.

**`IExecutionListener`** extends `ITestNGListener`, so it can be registered via `@Listeners` on a test class, in the `<listeners>` block of a `testng.xml`, or auto-detected via `ServiceLoader`. The "XML only, `@Listeners` is ignored" restriction applies to `IAnnotationTransformer`, not to `IExecutionListener`. This Workshop uses XML registration for `MyExecutionListener` so it reliably wraps every suite in the demo run:

```xml
<suite name="SuitesDemo" parallel="none">
    <listeners>
        <listener class-name="com.oleynik.qa.workshop.testng.suites.MySuiteListener"/>
        <listener class-name="com.oleynik.qa.workshop.testng.suites.MyExecutionListener"/>
    </listeners>
    <!-- ... -->
</suite>
```

Run the full suites demo:

```bash
./mvnw clean test -Dsurefire.suiteXmlFiles=src/test/resources/testngsuites.xml
./gradlew clean suiteTest -Psuite=src/test/resources/testngsuites.xml
```

### 2. Groups, `@BeforeGroups` / `@AfterGroups`

`GroupTest` → `grouping/` package  
Assign tests to named groups. Use `@BeforeGroups` and `@AfterGroups` for group-scoped setup/teardown.  
Run groups from the command line:

```bash
./mvnw clean test -Dgroups=Regression,Smoke
./gradlew clean test -PincludeGroups=Regression,Smoke
```

Or target a specific XML suite that filters by group:

```bash
# Run only Smoke tests via XML
./mvnw clean test -Dsurefire.suiteXmlFiles=src/test/resources/testnggroups2.xml
./gradlew clean suiteTest -Psuite=src/test/resources/testnggroups2.xml

# Run groups-of-groups (Smoke + Regression + Fail) via XML
./mvnw clean test -Dsurefire.suiteXmlFiles=src/test/resources/testnggroups1.xml
./gradlew clean suiteTest -Psuite=src/test/resources/testnggroups1.xml
```

### 3. Test Dependencies

`DependenciesTest` → `dependencies/` package  
Chain tests so that a downstream test is skipped (not failed) when its upstream dependency fails, using `dependsOnMethods` or `dependsOnGroups`.

### 4. CSV & External Data Providers

`DynamicDataProviderTest`, `OuterDataProviderTest` → `ddt/` package  
- Load test data lazily from CSV files via an `Iterator`-based `@DataProvider`. Test data lives in `src/test/resources/numbers.csv`.
- Separate data-provider logic into a dedicated `MyDataProvider` class and reference it with `dataProviderClass`.
- Use the custom `@DataSource(path = "…")` annotation to bind a CSV file path to a test method at runtime.

### 5. Hamcrest matchers

`HamcrestTest`

Write expressive assertions with `assertThat`, `equalTo`, `is`, `closeTo`, `both…and`, and more.

### 6. Nested Test Classes

`NestedTest` → `nested/` package  
Group related scenarios (`Multiply`, `Divide`, `Add`) as public inner classes inside a parent class. Run them via `testnested.xml`:

```bash
./mvnw clean test -Dsurefire.suiteXmlFiles=src/test/resources/testnested.xml
./gradlew clean suiteTest -Psuite=src/test/resources/testnested.xml
```

### 7. Test Execution Order

`ExecutionOrderTest` → `execution/order/` package  
Control method execution order with the `priority` attribute on `@Test` (lower value = earlier execution). Methods without a priority run before prioritized ones.

### 8. Listeners

`TestListenerTest`, `MethodListenerTest` → `listeners/` package  
- **`ITestListener`** (`MyTestListener`) — react to test start, success, failure, and skip events. Ideal for screenshot capture on failure.  
- **`IInvokedMethodListener`** (`MyMethodListener`) — intercept every method invocation (including `@Before*` / `@After*`).  
- **`TestListenerAdapter`** (`MyExtendedTestListener`) — extend the adapter and override only the callbacks you need.  
Attach listeners declaratively with `@Listeners(value = MyTestListener.class)` or globally via a `testng.xml` `<listeners>` block.

### 9. Retry Strategies

`RetryTest` — `IRetryAnalyzer` + custom `@Retries(limit = N)` annotation applied per test method  
`RetryTransformerTest` — `IAnnotationTransformer` (`RetryTransformer`) injects `RetryAnalyzer` globally for every test in the suite without touching test source code  

Run the transformer-based retry suite:

```bash
./mvnw clean test -Dsurefire.suiteXmlFiles=src/test/resources/testngretrylistener.xml
./gradlew clean suiteTest -Psuite=src/test/resources/testngretrylistener.xml
```

### 10. Parallel Execution

Configured globally in `pom.xml` via Surefire:

```xml
<parallel>methods</parallel>
<threadCount>3</threadCount>
```

Tests run concurrently by default. Fine-tune parallelism per suite with `parallel="classes"` or `parallel="tests"` and a custom `thread-count` in any `testng.xml`. For example, `testng2.xml` runs a fixed set of classes in parallel with `thread-count="2"`:

```bash
./mvnw clean test -Dsurefire.suiteXmlFiles=src/test/resources/testng2.xml
./gradlew clean suiteTest -Psuite=src/test/resources/testng2.xml
```

Gradle uses native TestNG integration with the same method-level parallelism:

```groovy
test {
    maxParallelForks = 1
    useTestNG {
        parallel = 'methods'
        threadCount = 3
    }
}
```

`maxParallelForks = 1` allows one Gradle test worker JVM. TestNG's `threadCount = 3`
controls the method threads inside that JVM. Gradle's `--max-workers` limits
Gradle task workers separately; it does not set the TestNG thread count.

### 11. TestNG XML Suites

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
./mvnw clean test -Dsurefire.suiteXmlFiles=src/test/resources/testng1.xml
./gradlew clean suiteTest -Psuite=src/test/resources/testng1.xml
```

`suiteTest` and `-Psuite` are implemented in this project's `build.gradle`;
`-Psuite` is not a built-in Gradle option. The path is relative to the repository
root (an absolute path also works). A missing parameter, missing file, or directory
fails the task instead of falling back to ordinary test discovery.

This task uses the test runtime classpath and passes the selected XML to native
TestNG. XML controls classes/packages, method includes/excludes, listeners,
`preserve-order`, `parallel`, and `thread-count`. The `methods/3` defaults of the
ordinary `test` task are not applied to `suiteTest`: `testngsuites.xml` stays
sequential with `parallel="none"`, while `testng2.xml` uses `classes` and two threads.
Without group parameters, XML group selections are also preserved. The project
parameters `-PincludeGroups` and `-PexcludeGroups` explicitly override the respective
XML group selections when supplied; omit them to run the suite as authored.
See [TestNGOptions](https://docs.gradle.org/current/javadoc/org/gradle/api/tasks/testing/testng/TestNGOptions.html).

The tasks write separate results:

| Task        | HTML report                                | XML results                     |
|-------------|--------------------------------------------|---------------------------------|
| `test`      | `build/reports/tests/test/index.html`      | `build/test-results/test/`      |
| `suiteTest` | `build/reports/tests/suiteTest/index.html` | `build/test-results/suiteTest/` |

Run `./gradlew suiteTest -Psuite=src/test/resources/testngsuites.xml` without
`clean` to retain an existing ordinary test report. Changing `-Psuite` or the
selected XML file invalidates the suite task's up-to-date result.

[⬆ Back to Table of Contents](#-table-of-contents)

---

## 💻 Command Examples

### Run all tests (and generate the reports)

```bash
# Maven
./mvnw clean test

# Gradle (Windows PowerShell: .\gradlew.bat clean test)
./gradlew clean test
```

> Reports are written to:
>
> - Surefire report: `target/surefire-reports/index.html`
> - TestNG emailable report: `target/surefire-reports/emailable-report.html`

Gradle writes its HTML report to `build/reports/tests/test/index.html` and XML
results to `build/test-results/test/`. Maven outputs to `target/`; Gradle outputs
to `build/`. Each build compiles and tests the shared sources independently.
Gradle's `test` task can be up-to-date on repeat runs; use `clean test` or
`test --rerun-tasks` to force execution. The paired commands below show both build tools.
The examples use Bash syntax (Linux/macOS or Git Bash on Windows). Simple
`-D...` / `-P...` arguments do not need quotes in Bash; quote wildcard patterns
and paths containing spaces so the shell passes them as one literal argument.

In PowerShell, use `.\mvnw.cmd` and `.\gradlew.bat`, and quote complete property
arguments, especially dotted property names and XML paths:

```powershell
.\mvnw.cmd clean test "-Dtest=AssertTest"
.\gradlew.bat clean test --tests "AssertTest"

.\mvnw.cmd clean test "-Dsurefire.suiteXmlFiles=src/test/resources/testng1.xml"
.\gradlew.bat clean suiteTest "-Psuite=src/test/resources/testng1.xml"
```

### Run a single test class

```bash
./mvnw clean test -Dtest=AssertTest
./gradlew clean test --tests "AssertTest"
```

### Run a single test method

```bash
./mvnw clean test -Dtest=AssertTest#assert_equals_multiplication_test
./gradlew clean test --tests "AssertTest.assert_equals_multiplication_test"
```

### Run multiple test classes

```bash
./mvnw clean test -Dtest=AssertTest,HamcrestTest
./gradlew clean test --tests "AssertTest" --tests "HamcrestTest"
```

### Run test methods matching a pattern

```bash
./mvnw clean test "-Dtest=AssertTest#assert_equals*"
./gradlew clean test --tests "AssertTest.assert_equals*"
```

### Run test methods matching multiple patterns

```bash
./mvnw clean test "-Dtest=AssertTest#assert_equals*+assert_boolean*"
./gradlew clean test --tests "AssertTest.assert_equals*" --tests "AssertTest.assert_boolean*"
```

### Run tests by group

```bash
./mvnw clean test -Dgroups=Regression,Smoke
./gradlew clean test -PincludeGroups=Regression,Smoke
```

Use `Smoke` or `Regression` alone to select a single group. These case-sensitive,
comma-separated project parameters are connected to TestNG's `includeGroups`
and `excludeGroups`; Gradle does not interpret Maven's `-Dgroups` automatically.
Whitespace around each group name is ignored. For example, run Regression
methods except those also assigned to Smoke:

```bash
./mvnw clean test -Dgroups=Regression -DexcludedGroups=Smoke
./gradlew clean test -PincludeGroups=Regression -PexcludeGroups=Smoke
```

### Run a specific TestNG XML suite

```bash
./mvnw clean test -Dsurefire.suiteXmlFiles=src/test/resources/testng1.xml
./gradlew clean suiteTest -Psuite=src/test/resources/testng1.xml
```

### Compile, test, package, and install to local repo

```bash
./mvnw clean install
./gradlew clean build publishToMavenLocal
```

The Gradle `maven-publish` plugin publishes the Java component (JAR and POM) to
the local Maven repository with the same `com.oleynik.qa.workshop:testng-examples:2.0-SNAPSHOT`
coordinates as Maven. `build` runs verification before local publication.

### Skip tests (compile + package + install to local repo without running tests)

```bash
./mvnw clean install -DskipTests
./gradlew clean build testClasses publishToMavenLocal -x test
```

`testClasses` still compiles the tests, matching Maven's `-DskipTests` behavior.
Neither command executes the tests.

### Generate Surefire HTML report (quick)

```bash
./mvnw clean surefire-report:report
./gradlew clean test
```

> Surefire report is written to:
>
> - Surefire report: `target/reports/surefire.html`

### Enable full debug logging for troubleshooting

```bash
./mvnw clean test -X
./gradlew clean test --debug
```

[⬆ Back to Table of Contents](#-table-of-contents)

---

## 🧩 Supported Versions

| Library               | Version used |
|-----------------------|--------------|
| TestNG                | `7.12.0`     |
| AssertJ               | `3.27.7`     |
| Hamcrest              | `3.0`        |
| Lombok                | `1.18.48`    |
| OpenCSV               | `5.12.0`     |
| SLF4J                 | `2.0.18`     |
| Maven Surefire Plugin | `3.5.6`      |
| Gradle Wrapper        | `9.6.0`      |
| Java `--release`      | `21`         |

[⬆ Back to Table of Contents](#-table-of-contents)

---

## 🚦 CI / CD

This project uses **GitHub Actions** with a manually triggered workflow.

### Workflow — `maven.yml`

Triggered manually from **Actions → Run workflow** on GitHub.

| Input    | Required | Description                                                                                   |
|----------|----------|-----------------------------------------------------------------------------------------------|
| `groups` | No       | Group filter for the by-group job (e.g. `Smoke`, `Regression`). Leave empty to skip that job. |

### Jobs

| Job          | Name                   | Runs when                             | Maven command                            | Equivalent Gradle command                                   |
|--------------|------------------------|---------------------------------------|------------------------------------------|-------------------------------------------------------------|
| `regression` | Regression — all tests | Always                                | `./mvnw -B clean test`                   | `./gradlew --no-daemon clean test`                          |
| `by-group`   | By group — `{groups}`  | Only when `groups` input is filled in | `./mvnw -B clean test -Dgroups={groups}` | `./gradlew --no-daemon clean test -PincludeGroups={groups}` |

The current workflow executes Maven. The Gradle column gives the equivalent local/CI commands;
it does not change the workflow or its artifact paths.

Each job uploads two artifacts after completion — including on failure (`if: always()`):

| Artifact                                           | Source path                | Contents                                                                |
|----------------------------------------------------|----------------------------|-------------------------------------------------------------------------|
| `testng-reports` / `testng-reports-{groups}`       | `target/surefire-reports/` | Full HTML report — open `index.html` in a browser                       |
| `junit-xml-results` / `junit-xml-results-{groups}` | `target/surefire-reports/` | Raw JUnit XML files — compatible with CI dashboards and report parsers  |

### How to trigger

1. Go to the **Actions** tab on GitHub
2. Select **Java CI with Maven** in the left panel
3. Click **Run workflow**
4. Optionally fill in the **`groups`** field (e.g. `Smoke`) to also run the by-group job
5. Click **Run workflow**

### Downloading the reports

1. Click the completed workflow run
2. Scroll to **Artifacts** → download **`testng-reports`** (HTML) or **`junit-xml-results`** (XML)
3. Open `index.html` (from the TestNG report) in a browser

### Generating the report locally

```bash
# All tests
./mvnw clean test
./gradlew clean test

# By group
./mvnw clean test -Dgroups=Smoke
./gradlew clean test -PincludeGroups=Smoke
./mvnw clean test -Dgroups=Regression
./gradlew clean test -PincludeGroups=Regression
```

[⬆ Back to Table of Contents](#-table-of-contents)

---

## 🤖 AI Assistant Support

This project ships configuration files for AI coding assistants so they have full context about the tech stack, package layout, coding conventions, and TestNG-specific rules.

| Assistant                                            | File                                                                 | Description                                                                                                  |
|------------------------------------------------------|----------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------|
| **GitHub Copilot** (chat / completions / agent mode) | [`.github/copilot-instructions.md`](.github/copilot-instructions.md) | Always-on workspace instructions — project overview, conventions, key patterns, task recipes, what NOT to do |
| **JetBrains Junie**                                  | [`.junie/guidelines.md`](.junie/guidelines.md)                       | Project guidelines — full source layout, naming rules, threading constraints, learning path                  |
| **OpenAI Codex / Claude Code / Gemini CLI**          | [`AGENTS.md`](AGENTS.md)                                             | Agentic guidance — build & verify commands, feature index, common patterns, important rules                  |

All files cover:
- Full tech stack and versions
- `src/main` and `src/test` package breakdown with class inventory
- Naming conventions (`snake_case` test methods, `PascalCase` classes)
- TestNG-specific rules (e.g. `IExecutionListener` can be registered via `@Listeners`, XML, or `ServiceLoader` — unlike `IAnnotationTransformer`, which requires XML)
- Thread-safety constraints (`parallel=methods`, `threadCount=3` enabled by default)
- All run commands including Maven Wrapper

[⬆ Back to Table of Contents](#-table-of-contents)

---

## 📚 Additional Resources

- [TestNG Documentation](https://testng.org/)
- [TestNG GitHub](https://github.com/testng-team/testng)
- [AssertJ Documentation](https://assertj.github.io/doc/)
- [Hamcrest Tutorial](https://hamcrest.org/JavaHamcrest/tutorial)
- [Lombok Features](https://projectlombok.org/features/)
- [OpenCSV Documentation](https://opencsv.sourceforge.net/)
- [Maven Surefire Plugin](https://maven.apache.org/surefire/maven-surefire-plugin/)
- [Maven Surefire Report Plugin](https://maven.apache.org/surefire/maven-surefire-report-plugin/)
- [Maven Wrapper](https://maven.apache.org/wrapper/) — run Maven without a local installation
- [Gradle Java Plugin](https://docs.gradle.org/current/userguide/java_plugin.html)
- [Gradle Wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html) — run Gradle without a local installation
- [JUnit Workshop](https://github.com/a-oleynik/junit-workshop) — companion JUnit 6 examples (there are also branches with JUnit 5 & 4)
- [Selenium Example](https://github.com/a-oleynik/selenium-example) — real-world Selenium framework using TestNG
- [testng.xml Is Legacy. Here’s What Modern TestNG Suites Should Look Like](https://medium.com/@andrei.oleynik/testng-xml-is-a-legacy-concept-heres-what-modern-test-suites-should-look-like-bd5cb380db61) — article on modern TestNG suite configuration
- [Maven Surefire 3.6.0: What Happened to TestNG and testng.xml](https://medium.com/@andrei.oleynik/maven-surefire-3-6-0-what-happened-to-testng-and-testng-xml-ae5cb882d41a) — article about updates in Maven Surefire / Failsafe 3.6.0 connected with TestNG
- [Maven Wrapper: Why You Need It and How to Use It](https://medium.com/@andrei.oleynik/maven-wrapper-why-you-need-it-and-how-to-use-it-bfa7619078b6) — article about Maven Wrapper and how to use it in your project
- [How to Install and Set Up Java on Windows, macOS, and Ubuntu: JDK, Maven, and Gradle](https://medium.com/@andrei.oleynik/how-to-install-and-set-up-java-on-windows-macos-and-ubuntu-jdk-maven-and-gradle-728a732dd123) — comprehensive setup guide for JDK, Maven, and Gradle on all major OS

[⬆ Back to Table of Contents](#-table-of-contents)

---

## 🔗 Useful Links

- [**Java Download**](https://www.oracle.com/java/technologies/downloads/)
- [**Maven Download**](https://maven.apache.org/download.cgi)
- [**TestNG Releases**](https://github.com/testng-team/testng/releases)
- [**JUnit 6 Released — Clean-Up, Modernization & Minimal Disruption**](https://medium.com/@andrei.oleynik/junit-6-released-clean-up-modernization-minimal-disruption-d3ecf11b64ad)
- [**What Is a Test Fixture in JUnit, and Why Is @BeforeEach Not a Fixture?**](https://medium.com/@andrei.oleynik/what-is-a-test-fixture-in-junit-and-why-is-beforeeach-not-the-fixture-53f5c750270e)
- [**Lombok Download**](https://projectlombok.org/download)
- [**IntelliJ Lombok Plugin**](https://plugins.jetbrains.com/plugin/6317-lombok)

[⬆ Back to Table of Contents](#-table-of-contents)

---

## ⭐ Found it useful?

If you found useful examples or information in this repository, please give it a ⭐  
Your support helps the project reach more Java and QA engineers.

---

## 📝 License

This project is licensed under the MIT License — see the [LICENSE](LICENSE) file for details.

[⬆ Back to Table of Contents](#-table-of-contents)

