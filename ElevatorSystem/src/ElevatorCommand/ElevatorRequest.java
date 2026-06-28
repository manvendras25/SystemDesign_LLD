package src.ElevatorCommand;

import commonEnum.Direction;
import src.utility.ElevatorController;

public class ElevatorRequest implements ElevatorCommand{

    private int elevatorId;
    private int floor;
    private Direction direction;
    private ElevatorController elevatorController;
    private boolean isInternalRequest;

    public ElevatorRequest(int elevatorId, int floor, Direction direction, boolean isInternalRequest) {
        this.elevatorId = elevatorId;
        this.floor = floor;
        this.direction = direction;
        this.elevatorController = new ElevatorController();
        this.isInternalRequest = isInternalRequest;
    }

    @Override
    public void execute() {
        if(isInternalRequest){
            elevatorController.requestFloor(elevatorId,floor);
        }
        else {
            elevatorController.requestElevator(elevatorId,floor,direction);
        }
    }
}
