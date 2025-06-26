package observer;

public class DashboardUpdater implements Observer {
    private String vehicleType;
    private String vehicleUsage;
    private String vehicleStatus;

    public DashboardUpdater(String vehicleType, String vehicleUsage, String vehicleStatus) {
        this.vehicleType = vehicleType;
        this.vehicleUsage = vehicleUsage;
        this.vehicleStatus = vehicleStatus;
    }

    @Override
    public void update(String rentalInfo) {
        // Simulate updating the dashboard with rental information
        System.out.println("Dashboard Update:");
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Vehicle Usage: " + vehicleUsage);
        System.out.println("Vehicle Status: " + vehicleStatus);
        System.out.println("Rental Info: " + rentalInfo);
        System.out.println("Dashboard updated successfully!\n");
    }  

}
