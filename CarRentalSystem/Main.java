import RentalSystem.RentalSystem;
import RentalSystem.RentalStore;
import User.User;
import VehicleFactory.ConcreteVehicle.NormalVehicle;
import VehicleFactory.Vehicle;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main (String[] args){


        RentalSystem rentalSystem = RentalSystem.getInstance();
        RentalStore rentalStore1 = new RentalStore(1,"MyCarStore","HSR");
        RentalStore rentalStore2 = new RentalStore(2,"CarMania","Belladur");

        Vehicle vehicle1 = rentalSystem.getVehicleFactory().createVehicle(1,"2025","Bugatti","Premium");
        Vehicle vehicle2 = rentalSystem.getVehicleFactory().createVehicle(2,"2025","Mercedes","Premium");
        Vehicle vehicle3 = rentalSystem.getVehicleFactory().createVehicle(3,"2025","Alto","Normal");
        Vehicle vehicle4 = rentalSystem.getVehicleFactory().createVehicle(4,"2025","Lambo","Premium");


        rentalStore1.addVehicle(vehicle1);
        rentalStore1.addVehicle(vehicle2);
        rentalStore2.addVehicle(vehicle3);
        rentalStore2.addVehicle(vehicle4);

        rentalSystem.addStore(rentalStore1);
        rentalSystem.addStore(rentalStore2);

        User user1 = new User(1,"Manvendra","manvendra@gmail.com");
        rentalSystem.registerUser(user1);
        Date startDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 2);
        Date twoDaysAhead = calendar.getTime();
        rentalSystem.createReservation(1,2,1,startDate,twoDaysAhead);
        rentalSystem.createReservation(1,2,1,startDate,startDate);
        rentalSystem.createReservation(1,1,1,startDate,twoDaysAhead);


        System.out.println("Reservation created now");





    }
}

