package observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SystemObserver {
    public static Object out;
    private List<Observer> observers = new ArrayList<>();
    private Map<String, String> rentalStatus = new HashMap<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }   

    private void notifyObservers(String rentalInfo) {
        for (Observer observer : observers) {
            observer.update(rentalInfo);
        }
    }

    public void rentVehicle(String userId, String vehicleId) {
        rentalStatus.put(vehicleId, "rented");
        String info = "User " + userId + " rented vehicle " + vehicleId;
        notifyObservers(info);
    }

    public void returnVehicle(String userId, String vehicleId) {
        rentalStatus.put(vehicleId, "available");
        String info = "User " + userId + " returned vehicle " + vehicleId;
        notifyObservers(info);
    }
}