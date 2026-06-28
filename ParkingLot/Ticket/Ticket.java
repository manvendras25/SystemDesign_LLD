package Ticket;

import ParkingSpot.ParkingSpot;
import PricingStrategy.PricingStrategy;
import Vehicle.Vehicle;

import java.time.Instant;

public class Ticket {
    private long entryTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    private PricingStrategy pricingStrategy;

    public Ticket(Vehicle vehicle,ParkingSpot parkingSpot,PricingStrategy pricingStrategy){
        this.entryTime = Instant.now().getEpochSecond();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.pricingStrategy=pricingStrategy;
    }

    public long calculateAmount(){
        long duration = (Instant.now().getEpochSecond() - entryTime);
        return pricingStrategy.calculate(vehicle,duration);
    }

    public long getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
}
