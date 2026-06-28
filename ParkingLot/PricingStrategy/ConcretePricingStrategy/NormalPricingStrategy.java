package PricingStrategy.ConcretePricingStrategy;

import PricingStrategy.PricingStrategy;
import Vehicle.Vehicle;

public class NormalPricingStrategy implements PricingStrategy {

    @Override
    public long calculate(Vehicle vehicle,long duration){
        return duration * vehicle.getParkingPrice();
    }

}
