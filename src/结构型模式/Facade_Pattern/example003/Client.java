package 结构型模式.Facade_Pattern.example003;

// 客户端代码
public class Client {
    public static void main(String[] args) {
        ComputerFacade computerFacade = new ComputerFacade();
        computerFacade.startComputer();
        System.out.println("-------------------");
        computerFacade.shutdownComputer();

        Computer Computer = new Computer();
        Computer.start();
        Computer.shutdown();
    }
}


// 计算机类
class Computer {
    private CPU cpu;
    private Memory memory;
    private HardDisk hardDisk;

    public Computer() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDisk = new HardDisk();
    }

    public void start() {
        cpu.start();
        memory.start();
        hardDisk.start();
        System.out.println("Computer started.");
    }

    public void shutdown() {
        hardDisk.shutdown();
        memory.shutdown();
        cpu.shutdown();
        System.out.println("Computer shutdown.");
    }
}


// CPU子系统类
class CPU {
    public void start() {
        System.out.println("CPU started.");
    }

    public void shutdown() {
        System.out.println("CPU shutdown.");
    }
}

// 内存子系统类
class Memory {
    public void start() {
        System.out.println("Memory started.");
    }

    public void shutdown() {
        System.out.println("Memory shutdown.");
    }
}

// 硬盘子系统类
class HardDisk {
    public void start() {
        System.out.println("HardDisk started.");
    }

    public void shutdown() {
        System.out.println("HardDisk shutdown.");
    }
}


// 外观类
class ComputerFacade {
    private Computer computer;

    public ComputerFacade() {
        this.computer = new Computer();
    }

    public void startComputer() {
        computer.start();
    }

    public void shutdownComputer() {
        computer.shutdown();
    }
}
