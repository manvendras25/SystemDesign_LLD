package src.ElevatorObserver;

import src.commonEnum.ElevatorState;
import src.utility.Elevator;

public interface ElevatorObserver {

    void onElevatorStateChange(Elevator elevator, ElevatorState state);

    void onElevatorFloorChange(Elevator elevator,int floor);
}
