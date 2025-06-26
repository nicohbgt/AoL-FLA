package observer;

public class Logger implements Observer {
    private String name;
    private String vehicleType;
    private String vehicleUsage;
    private String vehicleStatus;

    public Logger(String name, String vehicleType, String vehicleUsage, String vehicleStatus) {
        this.name = name;
        this.vehicleType = vehicleType;
        this.vehicleUsage = vehicleUsage;
        this.vehicleStatus = vehicleStatus;
    }

    @Override
    public void update(String rentalInfo) {
        // Simulate logging the rental information
        System.out.println("Logging rental information:");
        System.out.println("Logger: " + name);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Vehicle Usage: " + vehicleUsage);
        System.out.println("Vehicle Status: " + vehicleStatus);
        System.out.println("Rental Info: " + rentalInfo);
        System.out.println("Log entry created successfully!\n");
    }

}