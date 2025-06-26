package vehicle;

public class Camry implements Vehicle {
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
    private int tirePressure;
    private double mileage;
    private boolean isEngineOn;
    private boolean isLocked;
    private String location;
    private String status;

    public Camry(String color, String plateNumber, int productionYear, String chassisNumber,
                 String engineNumber, String vehicleUsage, String vehicleStatus,
                 double dailyRate, double fuelConsumptionKmPerLiter, double fuelTankCapacityLiters) {
        // Variabel Identitas Model (Hardcoded)
        this.brand = "Toyota";
        this.model = "New Camry";
        this.fuelType = "Gasoline"; // Sesuaikan jika ada varian Hybrid
        this.transmissionType = "Continuously Variable Transmission (CVT)"; // Sesuaikan jika ada varian lain
        this.vehicleType = "Sedan";

        // Variabel Identitas Instance (Dari Parameter)
        this.color = color;
        this.plateNumber = plateNumber;
        this.productionYear = productionYear;
        this.chassisNumber = chassisNumber;
        this.engineNumber = engineNumber;

        // Properti Kinerja (Dari Parameter)
        this.dailyRate = dailyRate;
        this.fuelConsumptionKmPerLiter = fuelConsumptionKmPerLiter;
        this.fuelTankCapacityLiters = fuelTankCapacityLiters;

        this.vehicleUsage = vehicleUsage;
        this.status = vehicleStatus; // Status awal operasional

        // Inisialisasi Status Operasional
        this.fuelLevel = 50000; // Sesuai permintaan Anda, diasumsikan 50000 unit internal
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
        return (int) ((fuelLevel / 50000.0) * 100); // Konversi ke persentase berdasarkan 50000 unit
    }
    @Override
    public double getFuelLevelLiters() {
        return fuelLevel / 1000.0; // Mengasumsikan 50000 unit internal = 50 liter
    }
    @Override
    public int getTirePressure() { return tirePressure; }
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
    public void drive(double distanceKm) { // Menggunakan double untuk konsisten
        if (isEngineOn && !isLocked) {
            mileage += 17; // Simulasi driving seperti yang Anda inginkan
            fuelLevel -= 1000; // Simulasi fuel consumption seperti yang Anda inginkan

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
        if (fuelLevel < 50000) {
            fuelLevel = 50000; // Refuel to full (50000 unit internal)
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
        System.out.println("Tire Pressure: " + tirePressure + " PSI");
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
        this.fuelLevel = Math.max(0, Math.min(fuelLevel, 50000.0)); // Batas maksimum 50000 unit
    }

    public void setTirePressure(int psi) {
        if (psi > 0) {
            this.tirePressure = psi;
            System.out.println(model + " (" + plateNumber + ") tire pressure set to " + psi + " PSI.");
        } else {
            System.out.println("Invalid tire pressure value. Must be positive.");
        }
    }
}