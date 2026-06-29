package RentalSystem;

import Reservation.Reservation;
import Reservation.ReservationManager;
import User.User;
import VehicleFactory.VehicleFactory;
import VehicleFactory.Vehicle;

import java.util.*;

public class RentalSystem {

    private static RentalSystem instance;
    private Map<Integer,RentalStore> stores;
    private ReservationManager reservationManager;
    private VehicleFactory vehicleFactory;
    private Map<Integer, User> users;


    public Map<Integer, User> getUsers() {
        return users;
    }

    public void setUsers(Map<Integer, User> users) {
        this.users = users;
    }

    public VehicleFactory getVehicleFactory() {
        return vehicleFactory;
    }

    public void setVehicleFactory(VehicleFactory vehicleFactory) {
        this.vehicleFactory = vehicleFactory;
    }

    public ReservationManager getReservationManager() {
        return reservationManager;
    }

    public void setReservationManager(ReservationManager reservationManager) {
        this.reservationManager = reservationManager;
    }

    public Map<Integer,RentalStore> getStores() {
        return stores;
    }



    private RentalSystem() {
        this.stores = new HashMap<>();
        this.vehicleFactory = new VehicleFactory();
        this.reservationManager = new ReservationManager();
        this.users = new HashMap<>();
    }

    public static synchronized RentalSystem getInstance(){
        if(instance == null){
            instance = new RentalSystem();
        }

        return instance;
    }

    public void addStore(RentalStore store){
        stores.put(store.getId(),store);
    }

    public RentalStore getStore(int storeId){
        if(stores.containsKey(storeId))return stores.get(storeId);

        return null;
    }

    public Reservation createReservation(int userId, int vehicleId, int storeId, Date startDate, Date endDate ){
        User user = users.get(userId);
        RentalStore store = stores.get(storeId);
        Vehicle vehicle = store != null ? store.getVehicle(vehicleId): null;

        if(user!=null && store !=null && vehicle != null && startDate !=null &&endDate !=null){

            if(vehicle.isAvailable(startDate,endDate))
            {
                return reservationManager.createReservation(
                        user,vehicle,store,startDate,endDate
                );
            }
            else {
                throw new IllegalArgumentException("This vehicle is Already booked for this period" + vehicle.toString());
            }

        }
        return null;
    }

    public void registerUser(User user)
    {
        int userId = user.getId();
        if(users.containsKey(userId)){
            System.out.println("This user already exists");
        }
        else users.put(userId,user);
    }

}
