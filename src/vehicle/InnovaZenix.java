package vehicle;

public class InnovaZenix implements Vehicle {
    private String brand;
    private String model;
    private String color;
    private String plateNumber;
    private int productionYear;
    private String chassisNumber;
    private String engineNumber;
    private String fuelType;
    private String transmissionType;
    private String vehicleType;
    private String vehicleUsage;
    private String vehicleStatus;

    private double dailyRate;
    private double fuelConsumptionKmPerLiter;
    private double fuelTankCapacityLiters;

    private double fuelLevel;
    private int tirePressure; // Akan merepresentasikan PSI
    private double mileage;
    private boolean isEngineOn;
    private boolean isLocked;
    private String location;
    private String status;

    public InnovaZenix(String color, String plateNumber, int productionYear,
                       String chassisNumber, String engineNumber, String vehicleUsage, String vehicleStatus,
                       double dailyRate, double fuelConsumptionKmPerLiter, double fuelTankCapacityLiters) {
        this.brand = "Toyota";
        this.model = "All New Kijang Innova Zenix";
        this.fuelType = "Gasoline";
        this.transmissionType = "Continuously Variable Transmission (CVT)";
        this.vehicleType = "Multipurpose Vehicle (MPV)";

        this.color = color;
        this.plateNumber = plateNumber;
        this.productionYear = productionYear;
        this.chassisNumber = chassisNumber;
        this.engineNumber = engineNumber;

        this.dailyRate = dailyRate;
        this.fuelConsumptionKmPerLiter = fuelConsumptionKmPerLiter;
        this.fuelTankCapacityLiters = fuelTankCapacityLiters;

        this.vehicleUsage = vehicleUsage;
        this.status = vehicleStatus;

        this.fuelLevel = 52000;
        this.tirePressure = 32; // Default 32 PSI
        this.mileage = 0.0;
        this.isEngineOn = false;
        this.isLocked = true;
        this.location = "Unknown";
    }

    @Override
    public String getBrand() { return brand; }
    @Override
    public String getModel() { return model; }
    @Override
    public String getColor() { return color; }
    @Override
    public String getPlateNumber() { return plateNumber; }
    @Override
    public int getProductionYear() { return productionYear; }
    @Override
    public String getChassisNumber() { return chassisNumber; }
    @Override
    public String getEngineNumber() { return engineNumber; }
    @Override
    public String getFuelType() { return fuelType; }
    @Override
    public String getTransmissionType() { return transmissionType; }
    @Override
    public String getVehicleType() { return vehicleType; }
    @Override
    public double getDailyRate() { return dailyRate; }
    @Override
    public double getFuelConsumptionKmPerLiter() { return fuelConsumptionKmPerLiter; }
    @Override
    public double getFuelTankCapacityLiters() { return fuelTankCapacityLiters; }

    @Override
    public int getFuelLevel() {
        return (int) ((fuelLevel / 52000.0) * 100);
    }
    @Override
    public double getFuelLevelLiters() {
        return fuelLevel / 1000.0;
    }
    @Override
    public int getTirePressure() { return tirePressure; } // Sekarang mengembalikan PSI
    @Override
    public int getMileage() { return (int) mileage; }
    @Override
    public boolean isEngineOn() { return isEngineOn; }
    @Override
    public boolean isLocked() { return isLocked; }
    @Override
    public String getLocation() { return location; }
    @Override
    public String getStatus() { return status; }
    @Override
    public String getVehicleUsage() { return vehicleUsage; }
    @Override
    public String getVehicleStatus() { return status; }

    @Override
    public void unlock() {
        if (isLocked) {
            isLocked = false;
            System.out.println(model + " (" + plateNumber + ") is unlocked.");
        } else {
            System.out.println(model + " (" + plateNumber + ") is already unlocked.");
        }
    }

    @Override
    public void startEngine() {
        if (!isEngineOn && !isLocked) {
            isEngineOn = true;
            System.out.println(model + " (" + plateNumber + ") engine started.");
        } else if (isLocked) {
            System.out.println("Cannot start engine, vehicle is locked.");
        } else {
            System.out.println(model + " (" + plateNumber + ") engine is already running.");
        }
    }

    @Override
    public void warmUp() {
        if (isEngineOn) {
            System.out.println(model + " (" + plateNumber + ") is warming up.");
        } else {
            System.out.println("Cannot warm up, engine is not running.");
        }
    }

    @Override
    public void drive(double distanceKm) {
        if (isEngineOn && !isLocked) {
            mileage += 18;
            fuelLevel -= 1000;

            if (fuelLevel < 0) fuelLevel = 0;

            System.out.printf("%s (%s) is driving. Mileage: %.0f km, Fuel Level: %.0f unit (%d%%)\n",
                              model, plateNumber, mileage, fuelLevel, getFuelLevel());
        } else if (isLocked) {
            System.out.println("Cannot drive, vehicle is locked.");
        } else {
            System.out.println("Cannot drive, engine is not running.");
        }
    }

    @Override
    public void refuel() {
        if (fuelLevel < 52000) {
            fuelLevel = 52000;
            System.out.println(model + " (" + plateNumber + ") refueled to 100%.");
        } else {
            System.out.println("Fuel level is already full.");
        }
    }

    @Override
    public void shutDownEngine() {
        if (isEngineOn) {
            isEngineOn = false;
            System.out.println(model + " (" + plateNumber + ") engine shut down.");
        } else {
            System.out.println(model + " (" + plateNumber + ") engine is already off.");
        }
    }

    @Override
    public void park() {
        if (!isLocked) {
            isLocked = true;
            System.out.println(model + " (" + plateNumber + ") parked and locked.");
        } else {
            System.out.println(model + " (" + plateNumber + ") is already parked and locked.");
        }
    }

    @Override
    public void lock() {
        if (!isLocked) {
            isLocked = true;
            System.out.println(model + " (" + plateNumber + ") is locked.");
        } else {
            System.out.println(model + " (" + plateNumber + ") is already locked.");
        }
    }

    @Override
    public void reportStatus() {
        System.out.println("\n--- " + brand + " " + model + " (" + plateNumber + ") Status Report ---");
        System.out.println("Fuel Level: " + String.format("%.0f", fuelLevel) + " unit internal (" + getFuelLevel() + "%)");
        System.out.println("Tire Pressure: " + tirePressure + " PSI"); // Menambahkan satuan PSI
        System.out.println("Mileage: " + String.format("%.0f", mileage) + " km");
        System.out.println("Engine Status: " + (isEngineOn ? "On" : "Off"));
        System.out.println("Lock Status: " + (isLocked ? "Locked" : "Unlocked"));
        System.out.println("Current Location: " + location);
        System.out.println("Vehicle Operational Status: " + status);
        System.out.println("Vehicle Usage: " + vehicleUsage);
    }

    @Override
    public void reportIssue() {
        System.out.println("Reporting issue for " + model + " (" + plateNumber + ").");
    }

    @Override
    public String reportLocation() {
        return model + " (" + plateNumber + ") is currently at: " + location;
    }

    @Override
    public String getInfo() {
        return brand + " " + model + " (Plat: " + plateNumber + ", Warna: " + color + ", Tahun: " + productionYear +
               ") | Tipe: " + vehicleType + ", Transmisi: " + transmissionType + ", BBM: " + fuelType +
               " | Konsumsi: " + fuelConsumptionKmPerLiter + " km/L, Tangki: " + fuelTankCapacityLiters + " L" +
               " | Tarif Harian: Rp" + String.format("%.0f", dailyRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return dailyRate * days;
    }

    @Override
    public double estimateMaxRangeKm() {
        return fuelTankCapacityLiters * fuelConsumptionKmPerLiter;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = Math.max(0, Math.min(fuelLevel, 52000.0));
    }

    public void setTirePressure(int psi) { // Implementasi setter baru
        if (psi > 0) { // Pastikan tekanan tidak negatif
            this.tirePressure = psi;
            System.out.println(model + " (" + plateNumber + ") tire pressure set to " + psi + " PSI.");
        } else {
            System.out.println("Invalid tire pressure value. Must be positive.");
        }
    }
}