package cn.edu.saif.shared.common.logging;

import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class TimingApplicationActivityLogger implements ApplicationActivityLogger {
    private static Logger logger = Logger.getLogger(TimingApplicationActivityLogger.class.getName());

    /**
     * Increment count data
     * @param path
     */
    @Override
    public void increment(String path) {
        logger.finest("INCREMENT|path|" + path);
    }

    /**
     * Decrement count data
     * @param namespace
     */
    @Override
    public void decrement(String path) {
        logger.finest("DECREMENT|path|" + path);
    }

    /**
     * Track timing data
     * @param path
     * @param value The value to log
     */
    @Override
    public void time(String path, int value) {
        if (value < 0) {
            logger.finest("Attempting to time negative value for path: " + path + " - " + value);
        }
        else {
            logger.fine("TIME|path|" + path + "|value|" + value);
        }
    }

    /**
     * Hopefully we're not actually timing anything larger than an int can represent. This is just a convenience method
     * to save a cast and/or size check.
     * @param path
     * @param value The value to log
     */
    @Override
    public void time(String path, long value) {
        if (value < 0) {
            logger.finest("Attempting to time negative value for path: " + path + " - " + value);
        }
        else {
            logger.fine("TIME|path|" + path + "|value|" + value);
        }
    }

    /**
     * Convenience function to pass in a start and end time and have this method handle computing the difference.
     * @param path
     * @param start Start time of the operation (typically in ms from System.currentTimeMillis())
     * @param end End time of the operation (typically in ms from System.currentTimeMillis())
     */
    @Override
    public void time(String bucket, long start, long end) {
        long value = end - start;
        this.time(bucket, value);
    }
}
