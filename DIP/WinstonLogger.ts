// WinstonLogger.ts
import { createLogger, format, transports, Logger } from 'winston';
import { ILogger } from './ILogger';

export class WinstonLogger implements ILogger {
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

    logInfo(message: string): void {
        this.logger.info(message);
    }

    logError(message: string): void {
        this.logger.error(message);
    }

    logDebug(message: string): void {
        this.logger.debug(message);
    }
}
