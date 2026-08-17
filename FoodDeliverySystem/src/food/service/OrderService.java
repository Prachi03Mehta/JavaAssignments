package food.service;

import food.model.Discountable;
import food.model.FoodOrder;
import food.utility.OrderUtility;

/**
 * Service layer class responsible for processing orders:
 * printing bills and aggregating totals across many orders.
 */
public class OrderService {

    /** Prints the full bill/summary for a single order. */
    public void printBill(FoodOrder order) {
        System.out.println(OrderUtility.generateOrderSummary(order));
    }

    /** Prints bills for every order in the array. */
    public void processAllOrders(FoodOrder[] orders) {
        for (FoodOrder order : orders) {
            if (order != null) {
                printBill(order);
            }
        }
    }

    /** Sums the final payable amount across all orders. */
    public double getTotalRevenue(FoodOrder[] orders) {
        double total = 0.0;
        for (FoodOrder order : orders) {
            if (order == null) {
                continue;
            }
            double discount = (order instanceof Discountable)
                    ? ((Discountable) order).applyDiscount()
                    : 0.0;
            total += order.getAmount() - discount + order.calculateDeliveryCharge();
        }
        return total;
    }
}
