package food.model;

/**
 * Abstract base class representing a generic food order.
 * Holds common attributes shared by all order types and enforces
 * that every concrete subclass provides its own delivery charge logic.
 */
public abstract class FoodOrder {

    // ---------- Private data members ----------
    private int orderId;
    private String customerName;
    private double amount;

    // ---------- Static members ----------
    private static String restaurantName = "Tasty Bites Restaurant";
    private static int orderCounter = 0;

    // ---------- Constructor ----------
    public FoodOrder(int orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        orderCounter++; // increment every time an order object is created
    }

    // ---------- Abstract method (to be overridden) ----------
    public abstract double calculateDeliveryCharge();

    // ---------- Getters and Setters ----------
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static String getRestaurantName() {
        return restaurantName;
    }

    public static void setRestaurantName(String restaurantName) {
        FoodOrder.restaurantName = restaurantName;
    }

    // ---------- Static method to display total orders ----------
    public static void displayTotalOrders() {
        System.out.println("Total orders placed so far: " + orderCounter);
    }
}
