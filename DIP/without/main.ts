// main.ts
import { PaymentService } from './PaymentService';

const paymentService = new PaymentService();

// Simulating payments
try {
    paymentService.processPayment("Alice", 100.50);
    paymentService.processPayment("Bob", -20.00);  // This will cause an error
} catch (error) {
    console.error("Payment processing failed");
}
