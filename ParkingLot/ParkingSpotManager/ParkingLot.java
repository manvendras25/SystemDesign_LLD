package ParkingSpotManager;

import ParkingSpot.ParkingSpot;
import PricingStrategy.PricingStrategy;
import Ticket.Ticket;
import Vehicle.Vehicle;

import java.util.List;

public class ParkingLot {
    private List<ParkingSpot> parkingSpots;

    public ParkingLot(List<ParkingSpot> parkingSpots){
        this.parkingSpots = parkingSpots;
    }

    public ParkingSpot findParkingSpot(Vehicle vehicle){

        for(ParkingSpot spot:parkingSpots){
            if(!spot.isOccupied()&& spot.getSpotType().equals(vehicle.getVehicleType())) {
                return spot;
            }
        }
        return null;
    }


    public Ticket parkVehicle(Vehicle vehicle, PricingStrategy pricingStrategy){

        ParkingSpot spot = findParkingSpot(vehicle);

        if(spot.isOccupied()){
            System.out.println("Cannot park");
            return null;
        }

        spot.parkVehicle(vehicle);

        Ticket ticket = new Ticket(vehicle,spot,pricingStrategy);

        return ticket;
    }

    public void removeVehicle(Ticket ticket){

        ParkingSpot spot = ticket.getParkingSpot();

        spot.removeVehicle();

        System.out.println("Vehicle removed");
    }

}
