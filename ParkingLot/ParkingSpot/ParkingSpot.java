package ParkingSpot;

import Vehicle.Vehicle;

public abstract class ParkingSpot {
    private int id;
    private boolean isOccupied;
    private Vehicle vehicle;
    private String spotType;

    public ParkingSpot(int id,String spotType){
        this.id = id;
        this.spotType = spotType;
    }

    public void parkVehicle(Vehicle vehicle){

        if(isOccupied){
            System.out.println("Spot not empty");
            return ;
        }
        if(!spotType.equals(vehicle.getVehicleType())){
            System.out.println("Not the same spotType");
            return ;
        }

        this.vehicle = vehicle;
        this.isOccupied = true;

    }

    public void removeVehicle(){
        if(!isOccupied){
            System.out.println("Already removed");
            return ;
        }

        this.vehicle = null;
        this.isOccupied = false;

    }

    public String getSpotType() {
        return spotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public int getId() {
        return id;
    }
}
