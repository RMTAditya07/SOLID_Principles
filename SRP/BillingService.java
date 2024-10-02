import java.util.List;

public class BillingService {
    private ITaxCalculator taxCalculator;
    private List<Discount> discounts;
    private List<IOffer> offers;

    public BillingService(ITaxCalculator taxCalculator, List<Discount> discounts, List<IOffer> offers) {
        this.taxCalculator = taxCalculator;
        this.discounts = discounts;
        this.offers = offers;
    }

    public double calculateTotal(Product product) {
        double total = product.getPrice();


        //discounts
        for(Discount discount : discounts) {
            total -= discount.applyDiscount(product);
        }
        
        // offers
        for(IOffer offer : offers){
            if(offer.isApplicable()){
                total -= offer.applyOffer(product);
            }
        }

        total += taxCalculator.calculateTax(product);

        return total;
    
    }
}
