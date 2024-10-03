class BillingService {
    private IDiscount discount;

    // Constructor accepts a Discount type to be applied
    public BillingService(IDiscount discount) {
        this.discount = discount;
    }

    public double calculateFinalBill(double price) {
        return discount.applyDiscount(price);
    }
}