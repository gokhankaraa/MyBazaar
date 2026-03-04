import java.util.Date;

public class Technician extends Employee {
    private boolean isSenior;

    public Technician(String name, String email, Date dateOfBirth, double salary, boolean isSenior) {
        super(name, email, dateOfBirth, salary);
        this.isSenior = isSenior;
    }

    public boolean isSenior() {
        return isSenior;
    }

    @Override
    public void displayPersonalData() {
        System.out.println("Technician name: " + getName());
        System.out.println("Technician e-mail: " + getEmail());
        System.out.println("Technician date of birth: " + getDateOfBirth());
    }

    @Override
    public void displayStockAmountAndItemTypes() {
    }

    @Override
    public void listAllAvailableItems() {
    }

    @Override
    public void displayVIPCustomers() {
    }

    public void displayAllOrders() {
    }

    public void displayItemInfo(int itemID) {
    }

    public void addNewItem() {
    }
}
