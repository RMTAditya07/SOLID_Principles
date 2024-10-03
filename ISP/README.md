# Interface Segregation Principle

> A class should not be forced to implement methods it doesn't need. In other words, a class should have small, focused interfaces rather than large, monolithic ones. 

**Violations of ISP:**
- **BasicPrinter is forced to implement methods it does not need**: Since BasicPrinter only supports printing, it shouldn’t have to deal with scan() and fax() methods. However, because of the large interface, it’s forced to implement them and throw exceptions.
- **Unnecessary complexity**: The BasicPrinter has methods that aren’t part of its responsibility, which increases the complexity of the code, making it less maintainable and prone to errors.
- **Error-prone design:** The client code must handle exceptions or check capabilities explicitly, which leads to more complex and error-prone code.

**By following ISP:**

- **Classes remain focused** on what they are meant to do.
- **No class is overloaded** with unnecessary responsibilities, leading to a cleaner and more maintainable design.
- **Future changes become easier** because you only need to modify specific parts of the system without affecting unrelated areas.