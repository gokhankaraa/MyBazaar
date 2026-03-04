import java.util.Date;

public abstract class Employee extends Person {
    private double salary;

    public Employee(String name, String email, Date dateOfBirth, double salary) {
        super(name, email, dateOfBirth);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public abstract void displayStockAmountAndItemTypes();
    public abstract void listAllAvailableItems();
    public abstract void displayVIPCustomers();
}
