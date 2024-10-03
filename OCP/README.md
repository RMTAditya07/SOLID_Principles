# Open Closed Principle

> **Open for Extension** : A software entity should allow its behavior to be extended. This means that we can add new functionality as the requirements of the application change.
**Closed for Modification** : The software entity should not require modification of its source code when we extend its behavior. This prevents changes to existing, stable code and reduces the risk of introducing new bugs.

#### Common techniques to apply OCP:

- Using Interfaces
- Using Abstract classes
- Using Polymorphism
- Using Strategy Pattern



#### Why should you use the open-closed principle?

- **You don't need to re-invent the wheel** : The code you and your team are working on is closed for extension. This means you don't need to re-invent the wheel(and rebuild everything) when you want to add new features.

- **You focus on what is necessary** : Your code is closed for modification. This means that you can add new features without performing too much editing on the existing code, or none at all. This can help you and your team members focus on what is necessary when it’s time to implement new functionalities.

- **You can avoid bugs** : since you don’t have to edit the existing code before adding new features, you can avoid introducting unnecessary bugs.