# SOLID Principles

SOLID stands for
- **S**ingle Responsibility Principle
- **O**pen-closed Principle
- **L**iskov Substitution Principle
- **I**nterface Segregation Principle
- **D**ependency Inversion Principle


## Single Responsibility Principle (SRP)

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


## Open/Closed Principle (OCP)

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


## Liskov Substitution Principle (LSP)

1. If S is a subtype of T, then objects of type T may be replaced with objects of type S without altering any of the desirable properties of the program.
2. In simpler terms, any implementation of an abstraction (interface) should be substitutable anywhere that abstraction is accepted.

**Why is LSP important?**
- When LSP is violated, it often leads to strange, hard-to-find bugs. 
- If your code relies on a specific subclass behavior, but you're using a base class reference, things can go awry.

### How LSP is applied in the code?

1. **Discount Classes**:
   - All discount classes implement the `Discount` interface.
   - The key point of LSP here is that any discount class should be substitutable for any other discount class, as long as it adheres to the expected behavior of the Discount interface (i.e., applying a discount to a product).
   - The PercentageDiscount and FlatRateDiscount classes are both substitutable for Discount.
   - In the BillingService, any discount can be applied without changing the billing logic, as long as it adheres to the Discount contract.
  
2. **Offer Classes**:
   - All offer classes implement the IOffer interface.
   -  According to the Liskov Substitution Principle, the BulkPurchaseOffer should be substitutable for any other class that implements IOffer, such as SeasonalOffer.
   -  The billing system will not need to change whether it is using a SeasonalOffer or a BulkPurchaseOffer, as both conform to the IOffer interface.
   -  This adheres to LSP because each class can substitute the other without breaking the program.

3. **Tax Calculators**

    - Tax calculators also adhere to LSP. Both StandardTaxCalculator and ReducedTaxCalculator implement the TaxCalculator interface and ==can be substituted for each other without causing errors.==
    - The BillingService will calculate the total correctly ==regardless of which tax calculator is being used==. 
    - This shows that the program can use different implementations of TaxCalculator without modifying any other part of the system, adhering to the Open/Closed Principle and Liskov Substitution Principle.
  
By adhering to LSP:

- New implementations can be introduced easily without needing to modify existing classes.
- Existing code remains functional and correct when using a subclass in place of its parent or an interface it implements.
- This ensures a robust and flexible system that can grow as new requirements (new discounts, offers, taxes, etc.) arise without violating the Liskov Substitution Principle.


## Interface Segregation Principle (ISP)

1. A class should not be forced to implement methods it doesn't need. 
2. In other words, a class should have small, focused interfaces rather than large, monolithic ones. 


### How ISP applies to the code:

1. **Discount Interface**:
    - The Discount interface, which has a single method applyDiscount(Product product), is a great example of an interface that is already adhering to ISP because it defines only one responsibility: applying a discount to a product. 
    - Each Discount class is responsible only for applying a discount based on its own criteria.
    ```
    public interface Discount {
        double applyDiscount(Product product);
    }
    ```
  
2. **Offer Interface**
    - Similarly, the IOffer interface contains only the methods relevant to checking if an offer is applicable and applying that offer to a product.
  
    ```
    public interface IOffer {
    boolean isApplicable();
    double applyOffer(Product product);
    }
    ```

3. **Tax Calculator Interface**
    - The TaxCalculator interface only includes the method to calculate tax, making it a well-segregated interface as well. 

    ```
    public interface ITaxCalculator {
        double calculateTax(Product product);
    }
    ```

==Violation Example==
```
    public interface BillingActions {
        double applyDiscount(Product product);
        boolean isOfferApplicable();
        double applyOffer(Product product);
        double calculateTax(Product product);
    }

```

Now, any class implementing this interface would need to implement all of these methods, even if it only needs one or two. For example, a tax calculator wouldn’t need to know about discounts or offers, and a discount class shouldn’t need to calculate taxes.

==Corrected Example with ISP==

To apply the Interface Segregation Principle, you can break this large interface into smaller, more specific interfaces, ensuring that each class implements only what it needs.
```
public interface Discount {
    double applyDiscount(Product product);
}

public interface IOffer {
    boolean isApplicable();
    double applyOffer(Product product);
}

public interface TaxCalculator {
    double calculateTax(Product product);
}

```

By following ISP:

- **Classes remain focused** on what they are meant to do.
- **No class is overloaded** with unnecessary responsibilities, leading to a cleaner and more maintainable design.
- **Future changes** become easier because you only need to modify specific parts of the system without affecting unrelated areas.