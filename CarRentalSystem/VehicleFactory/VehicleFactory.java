package VehicleFactory;

import VehicleFactory.ConcreteVehicle.NormalVehicle;
import VehicleFactory.ConcreteVehicle.PremiumVehicle;

public class VehicleFactory {

    public Vehicle createVehicle(int id,String model,String name,String vehicleType){

        return switch (vehicleType) {
            case "Normal" -> new NormalVehicle(id, model, name);
            case "Premium" -> new PremiumVehicle(id, model, name);
            default -> throw new IllegalArgumentException(
                    "VehicleType is not Supported :" + vehicleType
            );
        };
    }
}
