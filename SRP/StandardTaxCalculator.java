public class StandardTaxCalculator implements ITaxCalculator{
    
    @Override
    public double calculateTax(Product product) {
        return product.getPrice() * 0.10;
    }
}
