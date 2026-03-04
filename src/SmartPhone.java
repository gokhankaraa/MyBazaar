public class SmartPhone extends Electronic {
    private String screenType;

    public SmartPhone(double price, String manufacturer, String brand, int maxInputVoltage, int maxPowerConsumption, String screenType) {
        super(price, manufacturer, brand, maxInputVoltage, maxPowerConsumption);
        this.screenType = screenType;
    }

    public String getScreenType() {
        return screenType;
    }

    @Override
    public String toString() {
        return "Type: SmartPhone\n" +
                "Item ID: " + getId() + "\n" +
                "Price: " + getPrice() + " $\n" +
                "Manufacturer: " + getManufacturer() + "\n" +
                "Brand: " + getBrand() + "\n" +
                "Max Volt: " + getMaxInputVoltage() + " V.\n" +
                "Max Watt: " + getMaxPowerConsumption() + " W.\n" +
                "Screen Type: " + screenType;
    }
}
