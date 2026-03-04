public abstract class Cosmetic extends Item {
    private String manufacturer;
    private String brand;
    private int expirationYear;
    private double weight;
    private boolean isOrganic;

    public Cosmetic(double price, String manufacturer, String brand, int expirationYear, double weight, boolean isOrganic) {
        super(price);
        this.manufacturer = manufacturer;
        this.brand = brand;
        this.expirationYear = expirationYear;
        this.weight = weight;
        this.isOrganic = isOrganic;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getBrand() {
        return brand;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isOrganic() {
        return isOrganic;
    }
}
