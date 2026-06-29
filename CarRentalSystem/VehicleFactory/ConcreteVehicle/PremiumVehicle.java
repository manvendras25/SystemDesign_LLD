package VehicleFactory.ConcreteVehicle;

import VehicleFactory.Vehicle;

public class PremiumVehicle extends Vehicle{

    public PremiumVehicle(int id,String model,String name) {
            super(id, model, name, 1500.00);
        }
}
