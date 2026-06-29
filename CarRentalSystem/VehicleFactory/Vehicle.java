package VehicleFactory;

import Reservation.Reservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vehicle {
    public int id;
    public String model;
    public String name;
    public double pricePerDay;
    public List<Reservation> reservations;


    public Vehicle(int id, String model, String name, Double pricePerDay)
    {
        this.id = id;
        this.model = model;
        this.name = name;
        this.pricePerDay = pricePerDay;
        this.reservations = new ArrayList<>();
    }


    public boolean isAvailable(Date startDate, Date endDate){

        for(Reservation reservation: reservations)
        {
            if (startDate.getTime() <= reservation.getEndDate().getTime()
                    &&
                    endDate.getTime() >= reservation.getStartDate().getTime()) {
                return false;
            }
        }
        return true;
    }

    public void addReservation(Reservation reservation)
    {
        reservations.add(reservation);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
