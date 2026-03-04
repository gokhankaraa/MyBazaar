import java.util.Date;
import java.util.List;

public class Order {
    private Date orderDate;
    private double totalCost;
    private List<Item> purchasedItems;
    private int customerID;

    public Order(Date orderDate, double totalCost, List<Item> purchasedItems, int customerID) {
        this.orderDate = orderDate;
        this.totalCost = totalCost;
        this.purchasedItems = purchasedItems;
        this.customerID = customerID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public List<Item> getPurchasedItems() {
        return purchasedItems;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void displayOrder() {
        System.out.println("Order date: " + orderDate);
        System.out.println("Customer ID: " + customerID);
        System.out.println("Total Cost: " + totalCost);
        System.out.println("Number of purchased items: " + purchasedItems.size());
    }
}
