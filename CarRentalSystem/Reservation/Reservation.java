package Reservation;

import RentalSystem.RentalStore;
import User.User;
import VehicleFactory.Vehicle;

import java.util.Date;

public class Reservation {
    public int id;
    public User user;
    public Vehicle vehicle;
    public RentalStore rentalStore;
    public Date startDate;
    public Date endDate;
    public double totalAmount;
    public String status;



    public Reservation(int id, User user, Vehicle vehicle, RentalStore rentalStore, Date startDate, Date endDate) {
        this.id = id;
        this.user = user;
        this.vehicle = vehicle;
        this.rentalStore = rentalStore;
        this.startDate = startDate;
        this.endDate = endDate;
        long diffInMillies = endDate.getTime() - startDate.getTime();
        int days = (int) (diffInMillies / (1000 * 60 * 60 * 24)) + 1;
        this.totalAmount = days * vehicle.getPricePerDay();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public RentalStore getRentalStore() {
        return rentalStore;
    }

    public void setRentalStore(RentalStore rentalStore) {
        this.rentalStore = rentalStore;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
