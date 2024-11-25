package 行为型模式.Command_Pattern.example004;

// 客户端代码
public class Client {
    public static void main(String[] args) {
        Light light = new Light();
        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);

        RemoteControl remoteControl = new RemoteControl(lightOnCommand, lightOffCommand);

        remoteControl.pressOnButton();   // 输出：Light is on.
        remoteControl.pressOffButton();  // 输出：Light is off.
    }
}

// 命令接口
interface Command {
    void execute();
}


// 打开电灯命令类
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// 关闭电灯命令类
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// 电灯类（接收者）
class Light {
    public void turnOn() {
        System.out.println("Light is on.");
    }

    public void turnOff() {
        System.out.println("Light is off.");
    }
}


// 遥控器类（请求者）
class RemoteControl {
    private Command onCommand;
    private Command offCommand;

    public RemoteControl(Command onCommand, Command offCommand) {
        this.onCommand = onCommand;
        this.offCommand = offCommand;
    }

    public void pressOnButton() {
        onCommand.execute();
    }

    public void pressOffButton() {
        offCommand.execute();
    }
}
