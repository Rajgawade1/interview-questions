# Comprehensive Tech Stack Study Guide

## 1. Java

### Core Java

* **SOLID Principles:** Understanding and application of each principle.

* **Interfaces:** Serializable and Cloneable interfaces.

* **Design Patterns:** Examples and benefits (explain the specific problem each pattern solves).

* **MDC Context:** Mapped Diagnostic Context for logging.

* **HashMap Internals:** How does `ConcurrentHashMap` achieve thread safety without locking the entire map, and how did its internal implementation change from Java 7 to 8?

* **Garbage Collection:** How do you troubleshoot a memory leak or high CPU spike caused by the JVM, and when would you choose G1GC over ZGC?

* **Memory Model:** Explain the "happens-before" relationship in Java and how the `volatile` keyword guarantees visibility across threads.

### Multithreading

* `Synchronized` keyword vs. `ConcurrentHashMap`.

* `CompletableFuture` vs. standard `Future`.

* `ExecutorService` framework.

* Using `HashMap` in a multithreaded program (and why it's problematic).

* **Concurrency Utilities:** In what scenario would you choose a `CountDownLatch` over a `CyclicBarrier`, or a `ReentrantLock` over a standard `synchronized` block?

* **Executors & Futures:** How do you chain asynchronous tasks using `CompletableFuture`, and how do you handle exceptions within that pipeline?

* **Thread Pooling:** How do you determine the optimal thread pool size for a highly concurrent I/O-bound application versus a CPU-bound application?

### Java 8

* Can we have multiple abstract methods in a functional interface?

* What is the benefit of a functional interface?

* Examples of built-in functional interfaces in Java (e.g., `Predicate`, `Function`, `Supplier`, `Consumer`).

* **Stream APIs:** Coding examples to solve data manipulation problems such as grouping, sorting, and aggregation.

* **Stream API Performance:** When is using a `parallelStream()` actually slower than a sequential stream, and how does the underlying `ForkJoinPool` manage these tasks?

* **Functional Interfaces:** How do you write a custom functional interface, and how does the JVM handle lambda expressions internally (e.g., `invokedynamic`)?

* **Optional:** What are the common anti-patterns when using `Optional`, and why shouldn't it be used as a field in a class or a method parameter?

### Java 11

* **HTTP Client:** How does the Java 11 `HttpClient` improve upon `HttpURLConnection`, and how do you implement a non-blocking asynchronous HTTP call?

* **Local Variable Type Inference:** When does using `var` make code less readable, and why can't `var` be used for instance variables or method return types?

### Java 17

* **Records:** How do Records change the way we design immutable DTOs, and how do they handle serialization differently than standard classes?

* **Sealed Classes:** How do sealed classes enhance Domain-Driven Design and pattern matching by restricting the class hierarchy?

* **Pattern Matching:** How does pattern matching for `instanceof` (and `switch` expressions) reduce boilerplate and improve null safety?

## 2. Microservices

### Microservice Design Patterns

* CQRS (Command Query Responsibility Segregation)

* Saga Pattern

* 2PC (Two-Phase Commit)

* Resiliency

### Advanced Microservice Concepts

* **Observability:**

  * Distributed Tracing: How do you trace a single user request across 5 different microservices using Correlation IDs, Sleuth/Micrometer, and Zipkin/Jaeger?

  * Metrics & Logging: What is the difference between logging and metrics, and how do you aggregate logs centrally (ELK/Splunk) while avoiding performance bottlenecks?

* **Architecture & Boundaries:** How do you define bounded contexts when breaking down a monolith, and how do you handle cross-domain data querying?

* **CAP Theorem:** How do you balance Consistency and Availability in a highly distributed system, and how do you handle network partitions?

* **Saga Pattern:** Contrast Choreography vs. Orchestration for distributed transactions—when would you use an orchestrator like Camunda or Step Functions?

* **CQRS & Event Sourcing:** Why decouple read and write databases using CQRS, and how do you rebuild an application's state from an event store?

* **Resiliency Patterns:** How does a Circuit Breaker (like Resilience4j) prevent cascading failures, and what are the strategies for the "half-open" state?

## 3. Spring Boot

### Core Concepts

* **@Transactional Annotation:** Detailed working mechanism.

* **Auto-Configuration:** How does Spring Boot's `@EnableAutoConfiguration` work under the hood, and how would you build a custom Spring Boot Starter?

* **Context & Beans:** Explain the Spring Bean lifecycle. How do you resolve circular dependencies in Spring Boot 2.6+ where they are banned by default?

* **Actuator:** How do you secure Spring Boot Actuator endpoints in production, and how do you expose custom health indicators?

### Transaction Handling

* **Propagation & Isolation:** What happens if a `REQUIRES_NEW` transaction is called from a `REQUIRED` transaction, and how do you prevent "phantom reads"?

* **Proxy Limitations:** Why does calling a `@Transactional` method from within the same class fail to start a transaction, and how do you fix it?

### Security

* **OAuth2 & OIDC:** Explain the OAuth2 Authorization Code flow. What is the difference between an Access Token and an ID Token?

* **JWT:** How do you securely store JWTs on the client side to prevent XSS and CSRF, and how do you handle token invalidation/logout?

* **Spring Security Architecture:** Explain the Spring Security Filter Chain. How do you implement a custom authentication provider?

## 4. Angular

### Data Sharing & State Management

* **State Management:** When should you introduce NgRx or Signals into an application versus relying on standard Services and RxJS `BehaviorSubject`s?

* **Component Communication:** How do you share state efficiently between deeply nested sibling components without heavily polluting the parent component?

* **Signals (Angular 16+):** How do Angular Signals differ from RxJS Observables in terms of reactivity and change detection triggering?

### Web Federation (Webpack Module Federation)

* **Micro-Frontends:** How does Webpack Module Federation allow multiple separate Angular applications to run in a single host shell without page reloads?

* **Dependency Sharing:** How do you configure Module Federation to share singleton dependencies (like `@angular/core` or custom state services) across remote apps to prevent duplicate bundle loading?

### RxJS

* **Higher-Order Mapping:** In an auto-complete search bar, why must you use `switchMap` instead of `mergeMap`, `concatMap`, or `exhaustMap`?

* **Memory Management:** What are the most robust patterns to prevent memory leaks from unclosed subscriptions (e.g., `takeUntil`, `AsyncPipe`, `takeUntilDestroyed`)?

* **Subjects:** Explain the difference between `Subject`, `BehaviorSubject`, and `ReplaySubject`, and when you would use each.

### Event Handling & Performance

* **Change Detection:** How does the `OnPush` change detection strategy work, and what is the difference between `markForCheck()` and `detectChanges()`?

* **Zone.js:** When and why would you use `NgZone.runOutsideAngular()` to handle high-frequency events (like scrolling or mousemove)?

### Reactive Forms

* **Dynamic Forms:** How do you dynamically add and remove `FormGroup` elements within a `FormArray` based on user interaction?

* **Custom Validation:** How do you write a custom asynchronous validator to check if a username exists in the backend, and how do you debounce that backend call?

* **Cross-Field Validation:** How do you implement a validator at the `FormGroup` level to compare two fields (e.g., ensuring "Password" and "Confirm Password" match)?

### Authguards & Additional Concepts

* **Functional Guards:** How do you implement the newer functional route guards (Angular 15+) compared to the old class-based `CanActivate` interface?

* Routing with Resolve

* Data Sharing Techniques

* Standalone Components

* Services and Dependency Injection

* Interceptors

## 5. Database

### Core Database Concepts

* **Query Performance:** Tuning and optimization strategies.

* **Indexing:** Types of indexes and how they improve performance.

* **Partitioning:** Strategies for dividing large tables to improve maintainability and performance.

* **Sharding:** Distributing data across multiple machines for horizontal scaling.
