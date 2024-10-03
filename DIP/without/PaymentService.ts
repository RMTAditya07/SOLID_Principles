// PaymentService.ts
import { createLogger, format, transports, Logger } from 'winston';

export class PaymentService {
    private logger: Logger;

    constructor() {
        this.logger = createLogger({
            level: 'info',
            format: format.combine(
                format.timestamp(),
                format.printf(({ timestamp, level, message }) => {
                    return `${timestamp} [${level}]: ${message}`;
                })
            ),
            transports: [
                new transports.Console(),
                // You can add more transports here, like file logging.
            ],
        });
    }

    processPayment(customerName: string, amount: number): void {
        this.logger.info(`Processing payment for customer: ${customerName}`);

        if (amount <= 0) {
            this.logger.error(`Invalid payment amount: ${amount}`);
            throw new Error("Amount must be greater than zero.");
        }

        this.logger.debug(`Validating payment details for customer: ${customerName}`);
        // Simulate payment processing logic
        this.logger.info(`Payment of $${amount} processed successfully for customer: ${customerName}`);
    }
}
