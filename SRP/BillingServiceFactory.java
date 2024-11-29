import java.util.ArrayList;
import java.util.List;

public class BillingServiceFactory {

    public BillingService createBillingService(Product product, int quantity) {
        ITaxCalculator taxCalculator = determineTaxEligibility(product);

        List<Discount> discounts = new ArrayList<>();
        discounts.add(new PercentageDiscount(10));
        discounts.add(new FlatRateDiscount(50));

        List<IOffer> offers = new ArrayList<>();
        offers.add(new SeasonalOffer());
        offers.add(new BulkPurchaseOffer(quantity));

        return new BillingService(taxCalculator, getBestDiscount(discounts, product), getApplicableOffers(offers));
    }

    private ITaxCalculator determineTaxEligibility(Product product) {
        if (product.getPrice() > 500) {
            return new StandardTaxCalculator();
        } else {
            return new ReducedTaxCalculator();
        }
    }

    private List<Discount> getBestDiscount(List<Discount> discounts, Product product) {
        double maxDiscount = 0;
        Discount bestDiscount = null;

        for (Discount discount : discounts) {
            double discountAmount = discount.applyDiscount(product);
            if (discountAmount > maxDiscount) {
                maxDiscount = discountAmount;
                bestDiscount = discount;
            }
        }

        return bestDiscount != null ? List.of(bestDiscount) : new ArrayList<>();
    }

    private List<IOffer> getApplicableOffers(List<IOffer> offers) {
        List<IOffer> applicableOffers = new ArrayList<>();
        for (IOffer offer : offers) {
            if (offer.isApplicable()) {
                applicableOffers.add(offer);
            }
        }
        return applicableOffers;
    }
}
