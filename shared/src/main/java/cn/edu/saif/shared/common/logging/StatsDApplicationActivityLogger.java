package cn.edu.saif.shared.common.logging;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Qualifier("activityLogger")
public class StatsDApplicationActivityLogger implements ApplicationActivityLogger {
    private static Logger logger = Logger.getLogger(StatsDApplicationActivityLogger.class.getName());

    /**
     * Increment count data in StatsD.
     * @param bucket StatsD bucket name
     */
    @Override
    public void increment(String bucket) {
        // TODO: Actually send this data to StatsD
        logger.finer("INCREMENT: bucket: " + bucket);
    }

    /**
     * Decrement count data in StatsD.
     * @param bucket StatsD bucket name
     */
    @Override
    public void decrement(String bucket) {
        // TODO: Actually send this data to StatsD
        logger.finer("DECREMENT: bucket: " + bucket);
    }

    /**
     * Send timing data to StatsD.
     * @param bucket StatsD bucket name
     * @param value The value to send to StatsD
     */
    @Override
    public void time(String bucket, int value) {
        if (value < 0) {
            logger.finer("Attempting to time negative value for bucket: " + bucket + " - " + value);
        }
        else {
            // TODO: Actually send this data to StatsD
            logger.finer("TIME: bucket: " + bucket + " value: " + value);
        }
    }

    /**
     * Hopefully we're not actually timing anything larger than an int can represent. This is just a convenience method
     * to save a cast and/or size check.
     * @param bucket StatsD bucket name
     * @param value The value to send to StatsD
     */
    @Override
    public void time(String bucket, long value) {
        if (value < 0) {
            logger.finer("Attempting to time negative value for bucket: " + bucket + " - " + value);
        }
        else {
            // TODO: Actually send this data to StatsD
            logger.finer("TIME: bucket: " + bucket + " value: " + value);
        }
    }

    /**
     * Convenience function to pass in a start and end time and have this method handle computing the difference.
     * @param bucket StatsD bucket name
     * @param start Start time of the operation (typically in ms from System.currentTimeMillis())
     * @param end End time of the operation (typically in ms from System.currentTimeMillis())
     */
    @Override
    public void time(String bucket, long start, long end) {
        long value = end - start;
        this.time(bucket, value);
    }
}
