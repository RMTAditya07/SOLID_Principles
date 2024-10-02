public class FlatRateDiscount extends Discount{
    private double amount;

    public FlatRateDiscount(double amount) {
        this.amount = amount;
    }

    @Override
    public double applyDiscount(Product product) {
        return amount;
    }
}
