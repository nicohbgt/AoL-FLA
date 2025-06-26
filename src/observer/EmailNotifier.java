package observer;

public class EmailNotifier implements Observer{
    private String email;
    private String name;
    private String phoneNumber;
    private String address;
    private String vehicleType;
    private String vehicleUsage;
    private String vehicleStatus;

    public EmailNotifier(String email, String name, String phoneNumber, String address,
                         String vehicleType, String vehicleUsage, String vehicleStatus) {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.vehicleType = vehicleType;
        this.vehicleUsage = vehicleUsage;
        this.vehicleStatus = vehicleStatus;
    }

    @Override
    public void update(String rentalInfo) {
        // Simulate sending an email notification
        System.out.println("Sending Email Notification:");
        System.out.println("To: " + email);
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Vehicle Usage: " + vehicleUsage);
        System.out.println("Vehicle Status: " + vehicleStatus);
        System.out.println("Rental Info: " + rentalInfo);
        System.out.println("\n");
        System.out.println("Email sent successfully!\n");
    }
}
