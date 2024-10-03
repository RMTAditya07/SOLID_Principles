class VIPCustomerDiscount implements IDiscount {
    @Override
    public double applyDiscount(double price) {
        return price * 0.90; // 10% discount for VIP customers
    }
}
