import java.util.Date;

public abstract class Person {
    private String name;
    private String email;
    private Date dateOfBirth;

    public Person(String name, String email, Date dateOfBirth) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public abstract void displayPersonalData();
}
