import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean contineShoppping = true;

        List<Product> availableProducts = new ArrayList<>();
        availableProducts.add(new Product("Laptop", 100000));
        availableProducts.add(new Product("SmartPhone", 17000));
        availableProducts.add(new Product("Telephone", 7000));

        while (contineShoppping) {
            System.out.println("Welcome to the Shopping Cart!");
            System.out.println("Please select a product by typing the number: ");
            for (int i = 0; i < availableProducts.size(); i++) {
                System.out.println((i+1) + ". " + availableProducts.get(i).getName() + " - Rs."
                        + availableProducts.get(i).getPrice());
            }
            System.out.println("0. Quit");

            int choice = scanner.nextInt();
            if (choice == 0) {
                contineShoppping = false;
                System.out.println("Thank you for shopping with us!");
                break;
            }

            if (choice < 1 || choice > availableProducts.size()) {
                System.out.println("Invalid selection! Please try again.");
                continue;
            }

            Product selectedProduct = availableProducts.get(choice - 1);

            System.out.println("Enter the quantity of " + selectedProduct.getName() + ":");
            int quantity = scanner.nextInt();

            ITaxCalculator taxCalculator = determineTaxEligibility(selectedProduct);

            List<Discount> discounts = new ArrayList<>();
            discounts.add(new PercentageDiscount(10));
            discounts.add(new FlatRateDiscount(50));

            // Determine the best discount
            Discount bestDiscount = getBestDiscount(discounts, selectedProduct);

            List<IOffer> offers = new ArrayList<>();
            offers.add(new SeasonalOffer());
            offers.add(new BulkPurchaseOffer(quantity));

            // Determine applicable offers
            List<IOffer> applicableOffers = getApplicableOffers(offers);

            // Create billing service with the best discount and applicable offers
            BillingService billingService = new BillingService(taxCalculator, List.of(bestDiscount), applicableOffers);

            double total = billingService.calculateTotal(selectedProduct) * quantity;
            System.out.println("final price for " + quantity + " " + selectedProduct.getName() + "(s) : Rs. " + total);

            System.out.println("Do you want to continue shopping? (yes/no)");
            String continueAnswer = scanner.next();
            contineShoppping = continueAnswer.equalsIgnoreCase("yes");

        }
        scanner.close();
    }

    public static ITaxCalculator determineTaxEligibility(Product product) {

        if (product.getPrice() > 500) {
            System.out.println("Applying Standard Tax for " + product.getName());
            return new StandardTaxCalculator();
        } else if (product.getName().equalsIgnoreCase("Groceries")) {
            System.out.println("Applying Reduced Tax for " + product.getName());
            return new ReducedTaxCalculator();
        } else {
            System.out.println("Applying Standard Tax for " + product.getName());
            return new StandardTaxCalculator();
        }
    }

    // Method to find the best discount
    public static Discount getBestDiscount(List<Discount> discounts, Product product) {
        Discount bestDiscount = null;
        double highestDiscountAmount = 0;

        for (Discount discount : discounts) {
            double discountAmount = discount.applyDiscount(product);
            if (discountAmount > highestDiscountAmount) {
                highestDiscountAmount = discountAmount;
                bestDiscount = discount;
            }
        }

        if (bestDiscount != null) {
            System.out.println("Best discount applied: " + highestDiscountAmount);
        }
        return bestDiscount;
    }

    // Method to get applicable offers
    public static List<IOffer> getApplicableOffers(List<IOffer> offers) {
        List<IOffer> applicableOffers = new ArrayList<>();
        for (IOffer offer : offers) {
            if (offer.isApplicable()) {
                applicableOffers.add(offer);
                System.out.println("Offer applied: " + offer.getClass().getSimpleName());
            }
        }
        return applicableOffers;
    }
}
