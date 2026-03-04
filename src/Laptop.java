public class Laptop extends Computer {
    private boolean hasHdmiSupport;

    public Laptop(double price, String manufacturer, String brand, int maxInputVoltage, int maxPowerConsumption, String operatingSystem, String cpuType, int ramCapacity, int hddCapacity, boolean hasHdmiSupport) {
        super(price, manufacturer, brand, maxInputVoltage, maxPowerConsumption, operatingSystem, cpuType, ramCapacity, hddCapacity);
        this.hasHdmiSupport = hasHdmiSupport;
    }

    public boolean hasHdmiSupport() {
        return hasHdmiSupport;
    }

    @Override
    public String toString() {
        return "Type: Laptop\n" +
                "Item ID: " + getId() + "\n" +
                "Price: " + getPrice() + " $\n" +
                "Manufacturer: " + getManufacturer() + "\n" +
                "Brand: " + getBrand() + "\n" +
                "Max Volt: " + getMaxInputVoltage() + " V.\n" +
                "Max Watt: " + getMaxPowerConsumption() + " W.\n" +
                "Operating System: " + getOperatingSystem() + "\n" +
                "CPU Type: " + getCpuType() + "\n" +
                "RAM Capacity: " + getRamCapacity() + " GB.\n" +
                "HDD Capacity: " + getHddCapacity() + " GB.\n" +
                "HDMI Support: " + (hasHdmiSupport ? "Yes" : "No");
    }
}
