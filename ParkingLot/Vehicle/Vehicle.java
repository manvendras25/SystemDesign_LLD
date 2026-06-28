package Vehicle;

public class Vehicle {
     private String vehicleNumber;
     private String vehicleType;
     private long parkingPrice = 100;

     public Vehicle(String vehicleNumber,String vehicleType){
         this.vehicleNumber=vehicleNumber;
         this.vehicleType =vehicleType;
     }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public long getParkingPrice() {
        return parkingPrice;
    }
}
