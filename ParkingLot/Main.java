import ParkingSpot.ConcreteParkingSpot.BikeParkingSpot;
import ParkingSpot.ConcreteParkingSpot.CarParkingSpot;
import ParkingSpot.ParkingSpot;
import ParkingSpotManager.ParkingLot;
import PricingStrategy.ConcretePricingStrategy.NormalPricingStrategy;
import PricingStrategy.ConcretePricingStrategy.PremiumPricingStrategy;
import Ticket.Ticket;
import Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("This is my Main class");
//        Initialize the parking spots
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        parkingSpots.add(new BikeParkingSpot(1));
        parkingSpots.add(new BikeParkingSpot(2));
        parkingSpots.add(new CarParkingSpot(3));
        parkingSpots.add(new CarParkingSpot(4));

        ParkingLot parkingLot = new ParkingLot(parkingSpots);

        Vehicle bike1 = new Vehicle("UP1","Bike");
        Vehicle bike2 = new Vehicle("UP2","Bike");
        Vehicle car1 = new Vehicle("UP3","Car");
        Vehicle car2 = new Vehicle("UP4","Car");
//        Vehicle bike3 = new Vehicle("UP4","Bike");

        Ticket ticket1 = parkingLot.parkVehicle(bike1,new NormalPricingStrategy());
        Ticket ticket2 = parkingLot.parkVehicle(bike2,new PremiumPricingStrategy());
        Ticket ticket3 = parkingLot.parkVehicle(car1, new NormalPricingStrategy());
        Ticket ticket4 = parkingLot.parkVehicle(car2, new PremiumPricingStrategy());
//        Ticket ticket5 = parkingLot.parkVehicle(bike3, new NormalPricingStrategy());


        Thread.sleep(2000);
        System.out.println(ticket1.calculateAmount());
        System.out.println(ticket2.calculateAmount());
        System.out.println(ticket3.calculateAmount());
        System.out.println(ticket4.calculateAmount());

        parkingLot.removeVehicle(ticket1);
        parkingLot.removeVehicle(ticket2);
        parkingLot.removeVehicle(ticket3);
        parkingLot.removeVehicle(ticket4);

//        System.out.println(parkingSpots.get(2).getVehicle().getVehicleNumber());
    }
}
