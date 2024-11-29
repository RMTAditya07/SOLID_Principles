import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueShopping = true;

        // Initialize services
        ProductCatalogService productCatalog = new ProductCatalogService();
        productCatalog.addProduct(new Product("Laptop", 100000));
        productCatalog.addProduct(new Product("SmartPhone", 17000));
        productCatalog.addProduct(new Product("Telephone", 7000));

        BillingServiceFactory billingServiceFactory = new BillingServiceFactory();

        while (continueShopping) {
            // Display product catalog
            System.out.println("Welcome to the Shopping Cart!");
            productCatalog.displayProducts();

            System.out.println("0. Quit");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Thank you for shopping with us!");
                break;
            }

            // Validate product selection
            Product selectedProduct = productCatalog.getProduct(choice);
            if (selectedProduct == null) {
                System.out.println("Invalid selection! Please try again.");
                continue;
            }

            System.out.println("Enter the quantity of " + selectedProduct.getName() + ":");
            int quantity = scanner.nextInt();

            // Generate billing service with tax, discounts, and offers
            BillingService billingService = billingServiceFactory.createBillingService(selectedProduct, quantity);

            // Calculate total price
            double total = billingService.calculateTotal(selectedProduct) * quantity;

            System.out.println("Final price for " + quantity + " " + selectedProduct.getName() + "(s): Rs. " + total);

            System.out.println("Do you want to continue shopping? (yes/no)");
            String continueAnswer = scanner.next();
            continueShopping = continueAnswer.equalsIgnoreCase("yes");
        }

        scanner.close();
    }
}
