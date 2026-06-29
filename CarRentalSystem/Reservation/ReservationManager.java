package Reservation;

import RentalSystem.RentalStore;
import User.User;
import VehicleFactory.Vehicle;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReservationManager {

    public Map<Integer,Reservation> reservations;
    public int nextReservationId;

    public ReservationManager(){
        this.reservations = new HashMap<>();
        this.nextReservationId = 1;
    }

    public Reservation createReservation(User user, Vehicle vehicle, RentalStore rentalStore, Date startDate, Date endDate)
    {
        Reservation reservation = new Reservation(nextReservationId++,user,vehicle,rentalStore,startDate,endDate);

        reservations.put(reservation.getId(),reservation);
        vehicle.addReservation(reservation);
        user.addReservation(reservation);

        return reservation;
    }

}
