package PricingStrategy.ConcretePricingStrategy;

import PricingStrategy.PricingStrategy;
import Vehicle.Vehicle;

public class PremiumPricingStrategy implements PricingStrategy {

    @Override
    public long calculate(Vehicle vehicle, long duration){

        return duration * (vehicle.getParkingPrice()+50);
    }
}
