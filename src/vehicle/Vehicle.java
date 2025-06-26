package vehicle;

public interface Vehicle {
    String getBrand();
    String getModel();
    String getColor();
    String getPlateNumber();
    int getProductionYear();
    String getChassisNumber();
    String getEngineNumber();

    String getFuelType();
    String getTransmissionType();
    String getVehicleType();
    double getDailyRate();
    double getFuelConsumptionKmPerLiter();
    double getFuelTankCapacityLiters();

    double getFuelLevelLiters(); // Getter untuk liter (bukan persentase)
    int getFuelLevel(); // Getter untuk persentase
    int getTirePressure();
    int getMileage();
    boolean isEngineOn();
    boolean isLocked();
    String getLocation();
    String getStatus();
    String getVehicleUsage();
    String getVehicleStatus();

    void unlock();
    void startEngine();
    void warmUp();
    void drive(double distanceKm);
    void refuel();
    void shutDownEngine();
    void park();
    void lock();

    void reportStatus();
    void reportIssue();
    String reportLocation();
    String getInfo();

    double calculateRentalCost(int days);
    double estimateMaxRangeKm();

    // Setter untuk properti yang bisa berubah setelah objek dibuat
    void setLocation(String location);
    void setStatus(String status);
    void setFuelLevel(double fuelLevel);
}