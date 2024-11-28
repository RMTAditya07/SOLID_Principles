# Dependency Inversion Principle

>  high-level modules should not depend on low-level modules and both should depend on abstractions


**Benefits of Dependency Inversion Principle**
- Loose Coupling
- Testability
- Maintainability
- Scalability


**Problem without DIP**:

Without applying DIP, you might have high-level classes depending directly on concrete implementations, which causes the system to be rigid and difficult to extend. 

**How DIP is used in Code?**

- **High-Level Module (PaymentService)**:
  - This service class relies on the ILogger interface for logging. It does not depend on the concrete implementation (Winston), adhering to the Dependency Inversion Principle.
- **Low-Level Module (WinstonLogger):**
  - This class implements the ILogger interface, providing the actual logging functionality using Winston. If we ever want to change the logging library (e.g., to use a different logging framework), we can do so by creating a new implementation of ILogger.
- **Flexibility:**
  - You can easily replace WinstonLogger with another implementation without changing PaymentService, thus adhering to the DIP.


**Benefits of Using DIP:**
1. **Decoupling:** The high-level module does not depend on low-level modules directly, making the codebase more maintainable.
2. **Ease of Testing:** You can easily mock the ILogger interface when testing PaymentService, allowing for better unit tests.
3. **Flexibility and Maintainability:** Switching to a different logging library in the future would only require implementing the ILogger interface, leaving the high-level module unchanged.

**How the other code behaves without DIP?**

1. **Tight Coupling:**
In this example, the PaymentService class directly creates an instance of the Logger from the Winston library. This creates a dependency on the concrete implementation of the logger, violating the Dependency Inversion Principle.

2. **Reduced Flexibility:**
If you wanted to switch to a different logging library (like Bunyan or Pino), you would need to change the PaymentService code to accommodate the new library, leading to more maintenance work.

3. **Testing Challenges:**
It would be difficult to mock the logger when unit testing the PaymentService. You'd need to deal with the actual logging implementation, which could clutter the test output and make tests less isolated.
