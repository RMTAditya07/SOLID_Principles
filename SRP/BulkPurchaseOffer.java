public class BulkPurchaseOffer implements IOffer{
    private int quantity;

    public BulkPurchaseOffer(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean isApplicable() {
        return quantity >= 10; 
    }

    @Override
    public double applyOffer(Product product) {
        return product.getPrice() * 0.15;
    }

}
