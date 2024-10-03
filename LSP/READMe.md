# Liskov Substitution Principle

> If S is a subtype of T, then objects of type T may be replaced with objects of type T may be replaced with objects of type S without altering any of the desirable properties of the program


In simpler terms, any implementation of an abstraction (interface) should be substitutable anywhere that abstraction is accepted.

#### Why is LSP important?

- LSP is crucial to the maintainability of your code.
- When LSP is violated, it often leads to strange, hard-to-find bugs.
- If your code relies on a specific subclass behavior, but you're using a base class reference, things can go awry.
- Adhering to LSP helps avoid these bugs and makes your code more robust and flexible.

#### How This Applies to LSP:
- The Liskov Substitution Principle states that objects of a superclass should be ==replaceable with objects of its subclasses== without affecting the correctness of the program.
- In this case, FileService can ==accept any subclass of FileStorage==, whether it's LocalFileStorage or CloudFileStorage. The system remains flexible and functional, regardless of the specific type of storage used. You can later add new storage options (e.g., DatabaseFileStorage) without changing the FileService code.
- This approach ensures that the system is extensible and maintainable.

#### By adhering to LSP:

- New implementations can be introduced easily ==without needing to modify== existing classes.
- Existing code remains functional and correct when using a subclass in place of its parent or an interface it implements.
- This ensures a robust and flexible system that can grow as new requirements  arise without violating the Liskov Substitution Principle.
