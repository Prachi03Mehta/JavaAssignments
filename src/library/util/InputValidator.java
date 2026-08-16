package library.util;

public class InputValidator {

    // Validate Resource ID
    public static boolean validateResourceId(int resourceId) {
        return resourceId > 0;
    }

    // Validate Fine Days
    public static boolean validateFineDays(int overdueDays) {
        return overdueDays >= 0;
    }
}