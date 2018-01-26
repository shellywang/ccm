package cn.edu.saif.shared.common.logging;

public interface ApplicationActivityLogger {
    /**
     * Increment count data in an application logging collection system.
     * @param key logging system "key" (collection, bucket, etc.) name
     */
    void increment(String key);

    /**
     * Decrement count data in an application logging collection system.
     * @param key logging system "key" (collection, bucket, etc.) name
     */
    void decrement(String key);

    /**
     * Send timing data to an application logging collection system.
     * @param key logging system "key" (collection, bucket, etc.) name
     * @param value The timing value to send to an application logging collection system
     */
    void time(String key, int value);

    /**
     * Hopefully we're not actually timing anything larger than an int can represent. This is just a convenience method
     * to save a cast and/or size check.
     * @param key logging system "key" (collection, bucket, etc.) name
     * @param value The timing value to send to an application logging collection system
     */
    void time(String key, long value);

    /**
     * Convenience function to pass in a start and end time and have this method handle computing the difference.
     * @param key logging system "key" (collection, bucket, etc.) name
     * @param start Start time of the operation (typically in ms from System.currentTimeMillis())
     * @param end End time of the operation (typically in ms from System.currentTimeMillis())
     */
    void time(String key, long start, long end);
}
