package 行为型模式.Command_Pattern.example002;

public class Test {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ShutdownCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.action();
    }
}


interface Command{
    void execute();
}

class Receiver{
    public void action(){
        System.out.println("开始执行关机操作");
        System.out.println("退出所有程序进程");
        System.out.println("关机~");
    }
}

class ShutdownCommand implements Command{
    private Receiver receiver;
    public ShutdownCommand(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        System.out.println("命令角色执行关机命令");
        receiver.action();
    }
}

class Invoker{
    private Command command;
    public Invoker(Command command){
        this.command = command;
    }

    public void action(){
        System.out.println("调用者执行命令");
        command.execute();
    }
}

