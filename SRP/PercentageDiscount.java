public class PercentageDiscount extends Discount{
    private double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(Product product) {
        return product.getPrice() * (percentage / 100);
    }
}
