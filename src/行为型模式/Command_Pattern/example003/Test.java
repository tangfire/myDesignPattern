package 行为型模式.Command_Pattern.example003;

public class Test {
    public static void main(String[] args) {
        Light light = new Light();
        Command turnOnCommand = new TurnOnLightCommand(light);
        Command turnOffCommand = new TurnOffLightCommand(light);

        // 执行命令
        turnOnCommand.execute(); // 输出：灯已打开
        turnOffCommand.execute(); // 输出：灯已关闭

    }
}


interface Command {
    void execute();
}

class Light {
    public void turnOn() {
        System.out.println("灯已打开");
    }

    public void turnOff() {
        System.out.println("灯已关闭");
    }
}

class TurnOnLightCommand implements Command {
    private Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class TurnOffLightCommand implements Command {
    private Light light;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

