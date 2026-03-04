public abstract class Computer extends Electronic {
    private String operatingSystem;
    private String cpuType;
    private int ramCapacity;
    private int hddCapacity;

    public Computer(double price, String manufacturer, String brand, int maxInputVoltage, int maxPowerConsumption, String operatingSystem, String cpuType, int ramCapacity, int hddCapacity) {
        super(price, manufacturer, brand, maxInputVoltage, maxPowerConsumption);
        this.operatingSystem = operatingSystem;
        this.cpuType = cpuType;
        this.ramCapacity = ramCapacity;
        this.hddCapacity = hddCapacity;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getCpuType() {
        return cpuType;
    }

    public int getRamCapacity() {
        return ramCapacity;
    }

    public int getHddCapacity() {
        return hddCapacity;
    }
}
