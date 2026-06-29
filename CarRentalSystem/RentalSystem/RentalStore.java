package RentalSystem;

import VehicleFactory.Vehicle;
import VehicleFactory.VehicleFactory;

import java.util.*;

public class RentalStore {
    public int id;
    public String name;
    public String location;
    public Map<Integer, Vehicle> vehicles;


    public RentalStore(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.vehicles = new HashMap<>();
    }



    public List<Vehicle> getAvailableVehicles(Date startDate,Date endDate){
        List<Vehicle> availableVehicles = new ArrayList<>();

        vehicles.forEach((key,value)->{
            if(value.isAvailable(startDate,endDate))availableVehicles.add(value);
        });

        return availableVehicles;

    }

    public void addVehicle(Vehicle vehicle){
        vehicles.put(vehicle.getId(),vehicle);
    }

    public boolean removeVehicle(int id)
    {
        if(vehicles.containsKey(id)){
            vehicles.remove(id);
            return true;
        }

        throw new IllegalArgumentException("No such vehicle exits :" + id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Vehicle getVehicle(int vehicleId){
        if(vehicles.containsKey(vehicleId)){
            return vehicles.get(vehicleId);
        }
        throw new IllegalArgumentException("No such vehicle exists in store :" + vehicleId);
    }

    public Map<Integer, Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Map<Integer, Vehicle> vehicles) {
        vehicles = vehicles;
    }
}
