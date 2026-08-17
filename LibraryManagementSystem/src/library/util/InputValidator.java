package library.util;

/**
 * Utility class providing static validation helpers used
 * throughout the Smart Library Resource Management System.
 */
public class InputValidator {

    private InputValidator() {
        // pure utility class - no instances needed
    }

    /** Resource ID must be a positive integer (> 0). */
    public static boolean validateResourceId(int resourceId) {
        return resourceId > 0;
    }

    /** Overdue days cannot be negative (>= 0). */
    public static boolean validateFineDays(int overdueDays) {
        return overdueDays >= 0;
    }
}
