package factory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import vehicle.Agya;
import vehicle.Avanza;
import vehicle.Camry;
import vehicle.Fortuner;
import vehicle.InnovaReborn;
import vehicle.InnovaZenix;
import vehicle.Rush;
import vehicle.Vehicle;
import vehicle.Yaris;

public class VehicleFactory {

    public static class VehicleData {
        public String brand;
        public String modelName;
        public String fuelType;
        public String transmissionType;
        public String vehicleType;
        public int dailyRate;
        public double fuelConsumptionKmPerLiter;
        public double fuelTankCapacityLiters;
        public int cargoCapacityTons;

        public VehicleData(String brand, String modelName, String fuelType, String transmissionType,
                           String vehicleType, int dailyRate, double fuelConsumptionKmPerLiter,
                           double fuelTankCapacityLiters, int cargoCapacityTons) {
            this.brand = brand;
            this.modelName = modelName;
            this.fuelType = fuelType;
            this.transmissionType = transmissionType;
            this.vehicleType = vehicleType;
            this.dailyRate = dailyRate;
            this.fuelConsumptionKmPerLiter = fuelConsumptionKmPerLiter;
            this.fuelTankCapacityLiters = fuelTankCapacityLiters;
            this.cargoCapacityTons = cargoCapacityTons;
        }
    }

    private static final Map<String, VehicleData> vehicleSpecs = new HashMap<>();

    static {
        vehicleSpecs.put("INNOVA ZENIX HYBRID", new VehicleData(
            "Toyota", "All New Kijang Innova Zenix", "Hybrid", "Continuously Variable Transmission (CVT)",
            "Multipurpose Vehicle (MPV)", 600000, 19.0, 52.0, 0
        ));
        vehicleSpecs.put("INNOVA REBORN DIESEL", new VehicleData(
            "Toyota", "New Kijang Innova", "Diesel", "6 Speed Automatic Transmission",
            "Multipurpose Vehicle (MPV)", 450000, 12.0, 55.0, 0
        ));
        vehicleSpecs.put("AVANZA", new VehicleData(
            "Toyota", "All New Avanza", "Gasoline", "5 Speed M/T",
            "Multipurpose Vehicle (MPV)", 300000, 17.0, 43.0, 0
        ));
        vehicleSpecs.put("YARIS", new VehicleData(
            "Toyota", "New Yaris", "Gasoline", "7 Speed Continuously Variable Transmission (CVT)",
            "Hatchback", 280000, 16.0, 42.0, 0
        ));
        vehicleSpecs.put("RUSH", new VehicleData(
            "Toyota", "New Rush", "Gasoline", "4 Speed Automatic Transmission",
            "Sport Utility Vehicle (SUV)", 350000, 14.0, 45.0, 0
        ));
        vehicleSpecs.put("FORTUNER DIESEL", new VehicleData(
            "Toyota", "New Fortuner", "Diesel", "6 Speed Automatic Transmission",
            "Sport Utility Vehicle (SUV)", 700000, 12.0, 80.0, 0
        ));
        vehicleSpecs.put("AGYA", new VehicleData(
            "Toyota", "New Agya", "Gasoline", "Continuously Variable Transmission (CVT)",
            "Hatchback", 200000, 20.0, 33.0, 0
        ));
        vehicleSpecs.put("CAMRY HYBRID", new VehicleData(
            "Toyota", "New Camry", "Hybrid", "E-CVT",
            "Sedan", 800000, 24.0, 50.0, 0
        ));
    }

    public Vehicle createVehicle(String modelKey, String color, String plateNumber, int productionYear, String chassisNumber, String engineNumber, String vehicleUsage, String vehicleStatus, int dailyRate, double fuelConsumptionKmPerLiter, double fuelTankCapacityLiters) {

        VehicleData data = vehicleSpecs.get(modelKey.toUpperCase());

        if (data == null) {
            System.err.println("Error: Model kendaraan '" + modelKey + "' tidak ditemukan dalam spesifikasi.");
            return null;
        }

        switch (modelKey.toUpperCase()) {
            case "INNOVA ZENIX HYBRID" -> {
                return new InnovaZenix(color, plateNumber, productionYear, chassisNumber, engineNumber,
                        vehicleUsage, vehicleStatus,
                        data.dailyRate, data.fuelConsumptionKmPerLiter, data.fuelTankCapacityLiters);
            }
            case "INNOVA REBORN DIESEL" -> {
                return new InnovaReborn(color, plateNumber, productionYear, chassisNumber, engineNumber,
                        vehicleUsage, vehicleStatus,
                        data.dailyRate, data.fuelConsumptionKmPerLiter, data.fuelTankCapacityLiters);
            }
            case "AVANZA" -> {
                return new Avanza(color, plateNumber, productionYear, chassisNumber, engineNumber,
                        vehicleUsage, vehicleStatus,
                        data.dailyRate, data.fuelConsumptionKmPerLiter, data.fuelTankCapacityLiters);
            }
            case "YARIS" -> {
                return new Yaris(color, plateNumber, productionYear, chassisNumber, engineNumber,
                        vehicleUsage, vehicleStatus,
                        data.dailyRate, data.fuelConsumptionKmPerLiter, data.fuelTankCapacityLiters);
            }
            case "RUSH" -> {
                return new Rush(color, plateNumber, productionYear, chassisNumber, engineNumber,
                        vehicleUsage, vehicleStatus,
                        data.dailyRate, data.fuelConsumptionKmPerLiter, data.fuelTankCapacityLiters);
            }
            case "FORTUNER DIESEL" -> {
                return new Fortuner(color, plateNumber, productionYear, chassisNumber, engineNumber,
                        vehicleUsage, vehicleStatus,
                        data.dailyRate, data.fuelConsumptionKmPerLiter, data.fuelTankCapacityLiters);
            }
            case "AGYA" -> {
                return new Agya(color, plateNumber, productionYear, chassisNumber, engineNumber,
                        vehicleUsage, vehicleStatus,
                        data.dailyRate, data.fuelConsumptionKmPerLiter, data.fuelTankCapacityLiters);
            }
            case "CAMRY HYBRID" -> {
                return new Camry(color, plateNumber, productionYear, chassisNumber, engineNumber,
                        vehicleUsage, vehicleStatus,
                        data.dailyRate, data.fuelConsumptionKmPerLiter, data.fuelTankCapacityLiters);
            }
            default -> {
                System.err.println("Kelas konkret untuk model '" + modelKey + "' belum diimplementasikan atau tidak sesuai.");
                return null;
            }

        }
    }

    public static Map<String, VehicleData> getAvailableVehicleModels() {
        return Collections.unmodifiableMap(vehicleSpecs);
    }
}