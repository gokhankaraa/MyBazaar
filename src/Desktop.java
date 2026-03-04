public class Desktop extends Computer {
    private String boxColor;

    public Desktop(double price, String manufacturer, String brand, int maxInputVoltage, int maxPowerConsumption, String operatingSystem, String cpuType, int ramCapacity, int hddCapacity, String boxColor) {
        super(price, manufacturer, brand, maxInputVoltage, maxPowerConsumption, operatingSystem, cpuType, ramCapacity, hddCapacity);
        this.boxColor = boxColor;
    }

    public String getBoxColor() {
        return boxColor;
    }

    @Override
    public String toString() {
        return "Type: Desktop\n" +
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
                "Box Color: " + boxColor;
    }
}
