// PaymentService.ts
import { ILogger } from './ILogger';

export class PaymentService {
    private logger: ILogger;

    constructor(logger: ILogger) {
        this.logger = logger;
    }

    processPayment(customerName: string, amount: number): void {
        this.logger.logInfo(`Processing payment for customer: ${customerName}`);

        if (amount <= 0) {
            this.logger.logError(`Invalid payment amount: ${amount}`);
            throw new Error("Amount must be greater than zero.");
        }

        this.logger.logDebug(`Validating payment details for customer: ${customerName}`);
        // Simulate payment processing logic
        this.logger.logInfo(`Payment of $${amount} processed successfully for customer: ${customerName}`);
    }
}
