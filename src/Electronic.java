public abstract class Electronic extends Item {
    private String manufacturer;
    private String brand;
    private int maxInputVoltage;
    private int maxPowerConsumption;

    public Electronic(double price, String manufacturer, String brand, int maxInputVoltage, int maxPowerConsumption) {
        super(price);
        this.manufacturer = manufacturer;
        this.brand = brand;
        this.maxInputVoltage = maxInputVoltage;
        this.maxPowerConsumption = maxPowerConsumption;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getBrand() {
        return brand;
    }

    public int getMaxInputVoltage() {
        return maxInputVoltage;
    }

    public int getMaxPowerConsumption() {
        return maxPowerConsumption;
    }
}
