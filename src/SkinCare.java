public class SkinCare extends Cosmetic {
    private boolean isBabySensitive;

    public SkinCare(double price, String manufacturer, String brand, int expirationYear, double weight, boolean isOrganic, boolean isBabySensitive) {
        super(price, manufacturer, brand, expirationYear, weight, isOrganic);
        this.isBabySensitive = isBabySensitive;
    }

    public boolean isBabySensitive() {
        return isBabySensitive;
    }

    @Override
    public String toString() {
        return "Type: SkinCare\n" +
                "Item ID: " + getId() + "\n" +
                "Price: " + getPrice() + " $\n" +
                "Manufacturer: " + getManufacturer() + "\n" +
                "Brand: " + getBrand() + "\n" +
                "Organic: " + (isOrganic() ? "Yes" : "No") + "\n" +
                "Expiration Date: " + getExpirationYear() + "\n" +
                "Weight: " + getWeight() + " g.\n" +
                "Baby Sensitive: " + (isBabySensitive ? "Yes" : "No");
    }
}
