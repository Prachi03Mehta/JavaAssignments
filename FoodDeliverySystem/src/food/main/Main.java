package food.main;

import food.model.FoodOrder;
import food.model.PremiumOrder;
import food.model.RegularOrder;
import food.service.OrderService;
import food.utility.OrderUtility;

/**
 * Driver class for the Online Food Delivery Company application.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=== Online Food Delivery - Order Management ===\n");

        // ---------- Create at least six orders, stored as FoodOrder array ----------
        FoodOrder[] orders = new FoodOrder[6];

        orders[0] = new RegularOrder(101, "Amit Sharma", 500.00);
        orders[1] = new PremiumOrder(102, "Priya Verma", 1200.00);
        orders[2] = new RegularOrder(103, "Rohit Singh", 350.00);
        orders[3] = new PremiumOrder(104, "Sneha Kapoor", 900.00);
        orders[4] = new RegularOrder(105, "Karan Mehta", 620.00);
        orders[5] = new PremiumOrder(106, "Anjali Gupta", 1500.00);

        // ---------- Validate each order before processing ----------
        for (FoodOrder order : orders) {
            boolean validAmount = OrderUtility.validateAmount(order.getAmount());
            boolean validName = OrderUtility.validateCustomerName(order.getCustomerName());

            if (!validAmount || !validName) {
                System.out.println("Invalid order detected for Order ID "
                        + order.getOrderId() + " - skipping.");
            }
        }

        // ---------- Display bill, discount, delivery charge, final amount ----------
        OrderService orderService = new OrderService();
        orderService.processAllOrders(orders);

        // ---------- Summary statistics ----------
        System.out.println();
        FoodOrder.displayTotalOrders();
        System.out.printf("Total revenue collected across all orders: Rs. %.2f%n",
                orderService.getTotalRevenue(orders));
    }
}
