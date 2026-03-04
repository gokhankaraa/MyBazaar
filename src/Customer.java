import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer extends Person {
    private static int customerCount = 0;
    private int customerID;
    private String password;
    private double balance;
    private Status status;
    private ShoppingCart shoppingCart;
    private List<Order> orderHistory;

    public static final double SILVER_LIMIT = 1000.0;
    public static final double GOLDEN_LIMIT = 5000.0;
    public static final double SILVER_DISCOUNT = 0.10;
    public static final double GOLDEN_DISCOUNT = 0.15;

    public enum Status {
        CLASSIC,
        SILVER,
        GOLDEN
    }

    public Customer(String name, String email, Date dateOfBirth, double balance, String password) {
        super(name, email, dateOfBirth);
        this.customerID = ++customerCount;
        this.password = password;
        this.balance = balance;
        this.status = Status.CLASSIC;
        this.shoppingCart = new ShoppingCart();
        this.orderHistory = new ArrayList<>();
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public Status getStatus() {
        return status;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public void displayPersonalData() {
        System.out.println("Customer name: " + getName());
        System.out.println("Customer e-mail: " + getEmail());
        System.out.println("Customer date of birth: " + getDateOfBirth());
    }

    public void changePassword(String oldPassword, String newPassword) {
        if (this.password.equals(oldPassword)) {
            this.password = newPassword;
            System.out.println("The password has been successfully changed.");
        } else {
            System.out.println("The given password does not match the current password. Please try again.");
        }
    }

    public void updateBalance(double amount) {
        this.balance += amount;
    }

    public void viewActiveCampaigns() {
    }

    public void addToCart(Item item) {
        shoppingCart.addItem(item);
    }

    public void clearCart() {
        shoppingCart.clearCart();
    }

    public void placeOrder(String password, List<Campaign> campaigns) {
    }

    @Override
    public String toString() {
        return "Customer name: " + getName() + " ID: " + customerID + " e-mail: " + getEmail() + " Date of Birth: " + getDateOfBirth() + " Status: " + status;
    }
}
