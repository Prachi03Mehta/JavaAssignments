package food.utility;

import food.model.Discountable;
import food.model.FoodOrder;

/**
 * Utility class offering static helper methods for validation
 * and generation of order summaries.
 */
public class OrderUtility {

    // Private constructor - this is a pure utility class, no instances needed
    private OrderUtility() {
    }

    /** Amount must be a positive, non-zero value. */
    public static boolean validateAmount(double amount) {
        return amount > 0;
    }

    /** Customer name must not be null/empty and must contain only letters and spaces. */
    public static boolean validateCustomerName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        return name.matches("[a-zA-Z ]+");
    }

    /**
     * Builds a formatted, human-readable summary for a given order.
     * Works polymorphically for any FoodOrder subtype that also
     * implements Discountable.
     */
    public static String generateOrderSummary(FoodOrder order) {
        double deliveryCharge = order.calculateDeliveryCharge();
        double discount = 0.0;

        if (order instanceof Discountable) {
            discount = ((Discountable) order).applyDiscount();
        }

        double finalAmount = order.getAmount() - discount + deliveryCharge;

        StringBuilder sb = new StringBuilder();
        sb.append("-----------------------------------------\n");
        sb.append("Order ID       : ").append(order.getOrderId()).append("\n");
        sb.append("Restaurant     : ").append(FoodOrder.getRestaurantName()).append("\n");
        sb.append("Customer Name  : ").append(order.getCustomerName()).append("\n");
        sb.append("Order Type     : ").append(order.getClass().getSimpleName()).append("\n");
        sb.append(String.format("Bill Amount    : Rs. %.2f%n", order.getAmount()));
        sb.append(String.format("Discount       : Rs. %.2f%n", discount));
        sb.append(String.format("Delivery Charge: Rs. %.2f%n", deliveryCharge));
        sb.append(String.format("Final Payable  : Rs. %.2f%n", finalAmount));
        sb.append("-----------------------------------------");

        return sb.toString();
    }
}
