package src.utility;

import commonEnum.Direction;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    private List<Elevator> elevatorList;
    private List<Floor> floorList;
    private SchedulingStrategy schedulingStrategy;
    private int currentElevatorId;

    public ElevatorController(int numOfElevators,int numOfFloors)
    {
        elevatorList = new ArrayList<>();
        floorList = new ArrayList<>();

        for(int i=0;i<numOfElevators;i++)
        {
            elevatorList.add(new Elevator(i));
        }
        for(int i=0;i<numOfFloors;i++)
        {
            floorList.add(new Floor(i));
        }
    }

    public ElevatorController() {

    }

    public void requestFloor(int elevatorId,int floorNumber){

    }
    public void requestElevator(int elevatorId, int floorNumber, Direction direction){

    }
    public void step(){

    }

    public List<Elevator> getElevatorList() {
        return elevatorList;
    }

    public List<Floor> getFloorList() {
        return floorList;
    }

    public SchedulingStrategy getSchedulingStrategy() {
        return schedulingStrategy;
    }

    public int getCurrentElevatorId() {
        return currentElevatorId;
    }
}
