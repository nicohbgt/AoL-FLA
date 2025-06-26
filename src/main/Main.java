package main;

import factory.VehicleFactory;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import vehicle.Vehicle;

public class Main {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat datang di Sistem Manajemen Armada Rental!");
        System.out.println("------------------------------------------------");

        while (true) {
            System.out.println("\n--- Pilihan Menu ---");
            System.out.println("1. Tambahkan Kendaraan Baru ke Armada");
            System.out.println("2. Tampilkan Model Kendaraan yang Tersedia");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi (1-3): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Silakan masukkan angka.");
                continue;
            }

            switch (choice) {
                case 1:
                    addVehicleToFleet(factory, scanner);
                    break;
                case 2:
                    displayAvailableModels();
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan sistem kami!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opsi tidak valid. Silakan pilih 1, 2, atau 3.");
            }
        }
    }

    private static void addVehicleToFleet(VehicleFactory factory, Scanner scanner) {
        System.out.println("\n--- Tambah Kendaraan Baru ---");
        displayAvailableModels();

        System.out.print("Masukkan KEY model kendaraan yang ingin ditambahkan (misal: INNOVA ZENIX HYBRID): ");
        String modelKey = scanner.nextLine();

        // Validasi modelKey
        if (!VehicleFactory.getAvailableVehicleModels().containsKey(modelKey.toUpperCase())) {
            System.out.println("Model kendaraan '" + modelKey + "' tidak ada dalam daftar. Mohon masukkan key yang benar.");
            return;
        }

        System.out.print("Warna kendaraan: ");
        String color = scanner.nextLine();

        System.out.print("Nomor Plat: ");
        String plateNumber = scanner.nextLine();

        int productionYear = 0;
        try {
            System.out.print("Tahun Produksi: ");
            productionYear = Integer.parseInt(scanner.nextLine());
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Input tahun tidak valid. Menggunakan default 0.");
            scanner.nextLine(); // Clear invalid input
        }

        System.out.print("Nomor Rangka (Chassis Number): ");
        String chassisNumber = scanner.nextLine();

        System.out.print("Nomor Mesin (Engine Number): ");
        String engineNumber = scanner.nextLine();

        String vehicleUsage = "Rental"; // Default
        String vehicleStatus = "Available"; // Default

        // Mendapatkan data spesifikasi dari Factory untuk disuntikkan
        VehicleFactory.VehicleData modelData = VehicleFactory.getAvailableVehicleModels().get(modelKey.toUpperCase());
        if (modelData == null) {
            System.out.println("Terjadi kesalahan saat mengambil data model. Silakan coba lagi.");
            return;
        }

        // Membuat instance kendaraan menggunakan factory
        Vehicle newVehicle = factory.createVehicle(modelKey, color, plateNumber, productionYear,
                                                  chassisNumber, engineNumber, vehicleUsage, vehicleStatus,
                                                  modelData.dailyRate, modelData.fuelConsumptionKmPerLiter,
                                                  modelData.fuelTankCapacityLiters);

        if (newVehicle != null) {
            System.out.println("\n--- Kendaraan Baru Berhasil Dibuat ---");
            System.out.println(newVehicle.getInfo());
            System.out.println("Estimasi Jarak Tempuh Penuh Tangki: " + String.format("%.2f", newVehicle.estimateMaxRangeKm()) + " km");

            // Demonstrasi beberapa operasi
            System.out.println("\n--- Simulasi Operasional ---");
            newVehicle.unlock();
            newVehicle.startEngine();
            newVehicle.warmUp();
            newVehicle.drive(50); // Contoh: drive 50 km
            newVehicle.reportStatus();
            newVehicle.drive(100); // Contoh: drive 100 km lagi
            newVehicle.refuel();
            newVehicle.reportStatus();
            newVehicle.shutDownEngine();
            newVehicle.park();
            newVehicle.lock();

            // Anda bisa menyimpan 'newVehicle' ini ke dalam daftar armada
            // List<Vehicle> fleet = new ArrayList<>();
            // fleet.add(newVehicle);
        } else {
            System.out.println("Gagal membuat kendaraan. Silakan periksa model yang dimasukkan dan coba lagi.");
        }
    }

    private static void displayAvailableModels() {
        System.out.println("\n--- Daftar Model Kendaraan Tersedia ---");
        if (VehicleFactory.getAvailableVehicleModels().isEmpty()) {
            System.out.println("Tidak ada model kendaraan yang terdaftar.");
            return;
        }
        for (Map.Entry<String, VehicleFactory.VehicleData> entry : VehicleFactory.getAvailableVehicleModels().entrySet()) {
            VehicleFactory.VehicleData data = entry.getValue();
            System.out.println("- **KEY**: " + entry.getKey());
            System.out.println("  Brand: " + data.brand + ", Model: " + data.modelName + ", Tipe: " + data.vehicleType);
            System.out.println("  Transmisi: " + data.transmissionType + ", Jenis BBM: " + data.fuelType);
            System.out.println("  Tarif Harian: Rp" + String.format("%.0f", data.dailyRate));
            System.out.println("  Konsumsi BBM: " + data.fuelConsumptionKmPerLiter + " km/L, Kapasitas Tangki: " + String.format("%.0f", data.fuelTankCapacityLiters) + " L");
            System.out.println("------------------------------------");
        }
    }
}