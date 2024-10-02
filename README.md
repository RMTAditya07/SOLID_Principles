# SOLID Principles

SOLID stands for
- **S**ingle Responsibility Principle
- **O**pen-closed Principle
- **L**iskov Substitution Principle
- **I**nterface Segregation Principle
- **D**ependency Inversion Principle


## Single Responsibility Principle

1. A class or method should have ==only one reason== to change.
2. A class or method should have ==only one responsibility== to take care of.

What will happen if you write all kinds of responsibilities in one place?

- makes your code quite ==complex== and ==unmanageable==
- ==difficult to adjust new changes== later as there are high chances it will affect the other functionality
   
### How Single Responsibility Principle is applied in the code?

- **Product class** doesn't care about discounts, offers, or taxes - its only responsibility is to represent the product.
- **Discount and Offer classes** only deal with calculating their respective discounts and offers, making it easy to extend the system with new discounts or offers without affecting other parts of the code.
- **Tax classes** are solely responsible for tax calculations, so changes in tax rules will only affect these classes, without impacting how products or offers work.
- **Billing Service** has only one responsiblity : computing the final total after applying discounts, offers and tax. It doesn't deal with selecting the best discount or offer, which makes it simpler and less prone to errors when additional offers or discounts are added.
- **Main method** deals with user input and decision-making logic, making the overall flow clear and ensuring that decision-making is done outside of core service classes.

By adhering to SRP, the code becomes:
- **Easier to maintain:** Each class has a focused job, so changes in one area won't affect others.
- **Easier to extend:** Adding new discounts, offers, or tax types requires only minimal changes in the respective areas, without modifying the BillingService or Product class.
- **Easier to test:** Each class can be tested in isolation due to its single responsibility.

