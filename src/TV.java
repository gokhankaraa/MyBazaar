public class TV extends Electronic {
    private int screenSize;

    public TV(double price, String manufacturer, String brand, int maxInputVoltage, int maxPowerConsumption, int screenSize) {
        super(price, manufacturer, brand, maxInputVoltage, maxPowerConsumption);
        this.screenSize = screenSize;
    }

    public int getScreenSize() {
        return screenSize;
    }

    @Override
    public String toString() {
        return "Type: TV\n" +
                "Item ID: " + getId() + "\n" +
                "Price: " + getPrice() + " $\n" +
                "Manufacturer: " + getManufacturer() + "\n" +
                "Brand: " + getBrand() + "\n" +
                "Max Volt: " + getMaxInputVoltage() + " V.\n" +
                "Max Watt: " + getMaxPowerConsumption() + " W.\n" +
                "Screen Size: " + screenSize + "\"";
    }
}
