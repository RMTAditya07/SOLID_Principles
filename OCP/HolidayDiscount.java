class HolidayDiscount implements IDiscount {
    @Override
    public double applyDiscount(double price) {
        return price * 0.85; // 15% discount for holiday sale
    }
}