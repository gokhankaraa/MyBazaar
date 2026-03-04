import java.util.Date;

public class Admin extends Employee {
    private String password;

    public Admin(String name, String email, Date dateOfBirth, double salary, String password) {
        super(name, email, dateOfBirth, salary);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void displayPersonalData() {
        System.out.println("----------- Admin info -----------");
        System.out.println("Admin name: " + getName());
        System.out.println("Admin e-mail: " + getEmail());
        System.out.println("Admin date of birth: " + getDateOfBirth());
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

    public void addCustomer(String name, String email, Date dateOfBirth, double balance, String password) {
    }

    public void addAdmin(String name, String email, Date dateOfBirth, double salary, String password) {
    }

    public void addTechnician(String name, String email, Date dateOfBirth, double salary, boolean isSenior) {
    }

    public void displayCustomerData(int customerID) {
    }

    public void displayAllCustomers() {
    }

    public void launchCampaign() {
    }
}
