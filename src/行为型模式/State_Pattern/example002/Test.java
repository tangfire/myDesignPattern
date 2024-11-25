package 行为型模式.State_Pattern.example002;

public class Test {
    public static void main(String[] args) {
        Elevator elevator = new Elevator();

        elevator.openDoor();
        elevator.move();

        elevator.closeDoor();
        elevator.move();

        elevator.openDoor();
    }
}

interface ElevatorState {
    void openDoor(Elevator elevator);
    void closeDoor(Elevator elevator);
    void move(Elevator elevator);
}

class DoorClosedState implements ElevatorState {
    @Override
    public void openDoor(Elevator elevator) {
        System.out.println("电梯门打开");
        elevator.setState(new DoorOpenedState());
    }

    @Override
    public void closeDoor(Elevator elevator) {
        System.out.println("电梯门已关闭");
    }

    @Override
    public void move(Elevator elevator) {
        System.out.println("电梯开始移动");
        elevator.setState(new MovingState());
    }
}

class DoorOpenedState implements ElevatorState {
    @Override
    public void openDoor(Elevator elevator) {
        System.out.println("电梯门已打开");
    }

    @Override
    public void closeDoor(Elevator elevator) {
        System.out.println("电梯门关闭");
        elevator.setState(new DoorClosedState());
    }

    @Override
    public void move(Elevator elevator) {
        System.out.println("电梯不能移动，先关闭门");
    }
}

class MovingState implements ElevatorState {
    @Override
    public void openDoor(Elevator elevator) {
        System.out.println("电梯不能打开门，先停止移动");
    }

    @Override
    public void closeDoor(Elevator elevator) {
        System.out.println("电梯门关闭");
    }

    @Override
    public void move(Elevator elevator) {
        System.out.println("电梯正在移动");
    }
}

class Elevator {
    private ElevatorState currentState;

    public Elevator() {
        currentState = new DoorClosedState();
    }

    public void setState(ElevatorState state) {
        currentState = state;
    }

    public void openDoor() {
        currentState.openDoor(this);
    }

    public void closeDoor() {
        currentState.closeDoor(this);
    }

    public void move() {
        currentState.move(this);
    }
}
