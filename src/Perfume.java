public class Perfume extends Cosmetic {
    private int lastingDuration;

    public Perfume(double price, String manufacturer, String brand, int expirationYear, double weight, boolean isOrganic, int lastingDuration) {
        super(price, manufacturer, brand, expirationYear, weight, isOrganic);
        this.lastingDuration = lastingDuration;
    }

    public int getLastingDuration() {
        return lastingDuration;
    }

    @Override
    public String toString() {
        return "Type: Perfume\n" +
                "Item ID: " + getId() + "\n" +
                "Price: " + getPrice() + " $\n" +
                "Manufacturer: " + getManufacturer() + "\n" +
                "Brand: " + getBrand() + "\n" +
                "Organic: " + (isOrganic() ? "Yes" : "No") + "\n" +
                "Expiration Date: " + getExpirationYear() + "\n" +
                "Weight: " + getWeight() + " g.\n" +
                "Lasting Duration: " + lastingDuration + " min.";
    }
}
