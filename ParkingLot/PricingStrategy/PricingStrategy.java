package PricingStrategy;

import Vehicle.Vehicle;

public interface PricingStrategy {
    public long calculate(Vehicle vehicle, long duration);
}
