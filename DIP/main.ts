// main.ts
import { PaymentService } from './PaymentService';
import { WinstonLogger } from './WinstonLogger';

const logger = new WinstonLogger();
const paymentService = new PaymentService(logger);

// Simulating payments
try {
    paymentService.processPayment("Alice", 100.50);
    paymentService.processPayment("Bob", -20.00);  // This will cause an error
} catch (error) {
    logger.logError("Payment processing failed");
}
