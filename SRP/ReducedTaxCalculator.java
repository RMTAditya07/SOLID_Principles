
public class ReducedTaxCalculator implements ITaxCalculator {
    
    @Override
    public double calculateTax(Product product) {
        return product.getPrice() * 0.05; // 5% reduced tax
    }
}
