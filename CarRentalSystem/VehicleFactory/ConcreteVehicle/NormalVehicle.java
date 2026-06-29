package VehicleFactory.ConcreteVehicle;

import VehicleFactory.Vehicle;

public class NormalVehicle extends Vehicle {
    public NormalVehicle(int id,String model,String name) {
        super(id,model,name,1000.00);
    }


}
