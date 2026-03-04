public class HairCare extends Cosmetic {
    private boolean isMedicated;

    public HairCare(double price, String manufacturer, String brand, int expirationYear, double weight, boolean isOrganic, boolean isMedicated) {
        super(price, manufacturer, brand, expirationYear, weight, isOrganic);
        this.isMedicated = isMedicated;
    }

    public boolean isMedicated() {
        return isMedicated;
    }

    @Override
    public String toString() {
        return "Type: HairCare\n" +
                "Item ID: " + getId() + "\n" +
                "Price: " + getPrice() + " $\n" +
                "Manufacturer: " + getManufacturer() + "\n" +
                "Brand: " + getBrand() + "\n" +
                "Organic: " + (isOrganic() ? "Yes" : "No") + "\n" +
                "Expiration Date: " + getExpirationYear() + "\n" +
                "Weight: " + getWeight() + " g.\n" +
                "Medicated: " + (isMedicated ? "Yes" : "No");
    }
}
