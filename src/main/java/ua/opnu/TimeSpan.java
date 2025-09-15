package ua.opnu;

/**
 * Represents a span of time in hours and minutes.
 */
public final class TimeSpan {

    /** The number of minutes in one hour. */
    private static final int MINUTES_PER_HOUR = 60;

    /** The number of minutes in one hour as a double. */
    private static final double MINUTES_PER_HOUR_DOUBLE = 60.0;

    /** The number of whole hours in the time span. */
    private int hours;

    /** The number of minutes in the time span, from 0 to 59. */
    private int minutes;

    /**
     * Constructs a TimeSpan object.
     * If hours or minutes are invalid (negative or minutes >= 60),
     * the time span is initialized to 0 hours and 0 minutes.
     * Otherwise, the time is normalized.
     * @param hours The number of hours.
     * @param minutes The number of minutes.
     */
     TimeSpan(final int hours, final int minutes) {
        if (hours < 0 || minutes < 0 || minutes >= MINUTES_PER_HOUR) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            final int totalMinutes = hours * MINUTES_PER_HOUR + minutes;
            this.hours = totalMinutes / MINUTES_PER_HOUR;
            this.minutes = totalMinutes % MINUTES_PER_HOUR;
        }
    }

    /**
     * Gets the hours part of the time span.
     * @return The number of hours.
     */
     int getHours() {
        return this.hours;
    }

    /**
     * Gets the minutes part of the time span.
     * @return The number of minutes.
     */
     int getMinutes() {
        return this.minutes;
    }

    /**
     * Adds the specified amount of time to this time span.
     * The operation is aborted if the specified hours or minutes are invalid.
     * @param hours The number of hours to add.
     * @param minutes The number of minutes to add.
     */
     void add(final int hours, final int minutes) {
        if (hours < 0 || minutes < 0 || minutes >= MINUTES_PER_HOUR) {
            return;
        }
        final int currentTotalMinutes = this.getTotalMinutes();
        final int toAddTotalMinutes = hours * MINUTES_PER_HOUR + minutes;
        final int newTotalMinutes = currentTotalMinutes + toAddTotalMinutes;

        this.hours = newTotalMinutes / MINUTES_PER_HOUR;
        this.minutes = newTotalMinutes % MINUTES_PER_HOUR;
    }

    /**
     * Adds another TimeSpan to this one.
     * @param timespan The TimeSpan object to add.
     */
     void addTimeSpan(final TimeSpan timespan) {
        if (timespan != null) {
            this.add(timespan.getHours(), timespan.getMinutes());
        }
    }

    /**
     * Gets the total time span as a fractional number of hours.
     * For example, 9 hours and 45 minutes would be 9.75.
     * @return The total hours.
     */
     double getTotalHours() {
        return this.hours + (this.minutes / MINUTES_PER_HOUR_DOUBLE);
    }

    /**
     * Gets the total time span in minutes.
     * For example, 2 hours and 30 minutes would be 150.
     * @return The total minutes.
     */
     int getTotalMinutes() {
        return this.hours * MINUTES_PER_HOUR + this.minutes;
    }

    /**
     * Subtracts a time span from this one.
     * If the specified span is larger than the current one,
     * the operation is aborted and the current time span is not changed.
     * @param span The TimeSpan to subtract.
     */
     void subtract(final TimeSpan span) {
        if (span == null) {
            return;
        }

        final int currentTotalMinutes = this.getTotalMinutes();
        final int spanTotalMinutes = span.getTotalMinutes();

        if (spanTotalMinutes > currentTotalMinutes) {
            return;
        }

        final int newTotalMinutes = currentTotalMinutes - spanTotalMinutes;
        this.hours = newTotalMinutes / MINUTES_PER_HOUR;
        this.minutes = newTotalMinutes % MINUTES_PER_HOUR;
    }

    /**
     * Scales the current time span by a given factor.
     * The operation is aborted if the factor is not positive.
     * @param factor The positive integer factor to scale by.
     */
     void scale(final int factor) {
        if (factor <= 0) {
            return;
        }
        final int totalMinutes = this.getTotalMinutes() * factor;
        this.hours = totalMinutes / MINUTES_PER_HOUR;
        this.minutes = totalMinutes % MINUTES_PER_HOUR;
    }
}
