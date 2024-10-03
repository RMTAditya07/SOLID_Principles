class RegularCustomerDiscount implements IDiscount {
    @Override
    public double applyDiscount(double price) {
        return price * 0.95; // 5% discount for regular customers
    }
}