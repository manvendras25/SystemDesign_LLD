package src.utility;

import commonEnum.Direction;
import commonEnum.ElevatorState;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Elevator {
    public int id;
    public Floor currentFloor;
    public Direction direction;
    public ElevatorState elevatorState;

    public List<ElevatorObserver> observerList;
    public Queue<ElevatorRequest> requestQueue;


    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setElevatorState(ElevatorState elevatorState) {
        this.elevatorState = elevatorState;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Elevator(int id){
        this.id = id;
        this.currentFloor =0;
        this.direction = Direction.IDLE;
        this.elevatorState = ElevatorState.IDLE;
        this.observerList = new ArrayList<>();
        this.requestQueue = new LinkedList<>();
    }

    public addObserver(ElevatorObserver observer)
    {
        observerList.add(observer);
    }
    public removeObserver(ElevatorObserver observer)
    {
        observerList.remove(observer);
    }

    public addRequest(ElevatorRequest request){

    }


    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public ElevatorState getElevatorState() {
        return elevatorState;
    }

    public List<ElevatorObserver> getObserverList() {
        return observerList;
    }

    public Queue<ElevatorRequest> getRequestQueue() {
        return requestQueue;
    }
}
