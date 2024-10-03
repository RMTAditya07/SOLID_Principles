public class Main {
    public static void main(String[] args) {
        // Regular customer case
        IDiscount regularDiscount = new RegularCustomerDiscount();
        BillingService regularBilling = new BillingService(regularDiscount);
        System.out.println("Final bill for regular customer: " + regularBilling.calculateFinalBill(100.0));

        // VIP customer case
        IDiscount vipDiscount = new VIPCustomerDiscount();
        BillingService vipBilling = new BillingService(vipDiscount);
        System.out.println("Final bill for VIP customer: " + vipBilling.calculateFinalBill(100.0));

        // Holiday discount case (added without changing any other code)
        IDiscount holidayDiscount = new HolidayDiscount();
        BillingService holidayBilling = new BillingService(holidayDiscount);
        System.out.println("Final bill with holiday discount: " + holidayBilling.calculateFinalBill(100.0));
    }
}