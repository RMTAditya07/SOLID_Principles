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


## Open/Closed Principle

1. **Open for Extension** : A software entity should allow its behavior to be extended. This means that we can add new functionality as the requirements of the application change. 
2. **Closed for Modification** : The software entity should not require modification of its source code when we extend its behavior. This prevents changes to existing, stable code and reduces the risk of introducing new bugs.

Common techniques to apply OCP:

- Using Interfaces
- Using Abstract classes
- Using Polymorphism
- using Strategy Pattern

### How OCP is followed in the code ?

1. **Discounts and Offers**
   
   **Open for Extension**:
   - The `Discount` and `IOffer` interfaces allow new types of discounts or offers to be added easily by implementing new classes that extend these interfaces.
   - For example, if you want to add a new type of discount like a LoyaltyDiscount, you don’t need to modify the existing discount classes. You simply create a new class that implements the Discount interface
  
    **Closed for Modification:**
    - The existing discount classes (e.g., PercentageDiscount, FlatRateDiscount) do not need to be modified when adding new discount types. They are "closed" for modification.

2. **Tax Calculators**
    **Open for Extension**:
    - You can add new types of tax calculators (e.g., LuxuryTaxCalculator, ZeroTaxCalculator) without touching the existing StandardTaxCalculator and ReducedTaxCalculator classes. 
    - Just implement the TaxCalculator interface and create the new logic.
    **Closed for Modification**:
    - Existing tax calculators remain unchanged, meaning they are closed for modification.

3. **BillingService**
    **Open for Extension:**
    - You can pass in new types of discounts or tax calculators to the BillingService without changing its logic. This makes it open for extension—you can easily extend the billing process by introducing new discount types or tax rules.
    
    **Closed for Modification:**
    - The core logic in BillingService does not need to change when new types of discounts or offers are added. It is closed for modification.

**Benefits of OCP**:
- **Scalability :** New business rules, discounts, offers, or taxes can be added easily without affecting the existing system, making it more scalable.
- **Minimal Risk of Bugs :** Since the existing code doesn't need to be modified, there is a lower risk of introducing bugs when adding new features.
- **Ease of Maintanence :** The system becomes easier to maintain because new functionality can be added independently of the existing logic. 