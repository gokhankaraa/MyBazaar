public class Tablet extends Computer {
    private double dimension;

    public Tablet(double price, String manufacturer, String brand, int maxInputVoltage, int maxPowerConsumption, String operatingSystem, String cpuType, int ramCapacity, int hddCapacity, double dimension) {
        super(price, manufacturer, brand, maxInputVoltage, maxPowerConsumption, operatingSystem, cpuType, ramCapacity, hddCapacity);
        this.dimension = dimension;
    }

    public double getDimension() {
        return dimension;
    }

    @Override
    public String toString() {
        return "Type: Tablet\n" +
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
                "Dimension: " + dimension + " inches";
    }
}
