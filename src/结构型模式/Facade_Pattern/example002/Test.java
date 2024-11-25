package 结构型模式.Facade_Pattern.example002;

public class Test {
    public static void main(String[] args) {
        ComputerFacade computerFacade = new ComputerFacade();
        computerFacade.start();
        // 输出：
        // 计算机启动开始
        // CPU 启动
        // 内存启动
        // 硬盘启动
        // 计算机启动完成

        computerFacade.shutdown();
        // 输出：
        // 计算机关闭开始
        // CPU 关闭
        // 内存关闭
        // 硬盘关闭
        // 计算机关闭完成

    }
}


class CPU {
    public void start() {
        System.out.println("CPU 启动");
    }

    public void shutdown() {
        System.out.println("CPU 关闭");
    }
}

class Memory {
    public void start() {
        System.out.println("内存启动");
    }

    public void shutdown() {
        System.out.println("内存关闭");
    }
}

class HardDrive {
    public void start() {
        System.out.println("硬盘启动");
    }

    public void shutdown() {
        System.out.println("硬盘关闭");
    }
}

class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        cpu = new CPU();
        memory = new Memory();
        hardDrive = new HardDrive();
    }

    public void start() {
        System.out.println("计算机启动开始");
        cpu.start();
        memory.start();
        hardDrive.start();
        System.out.println("计算机启动完成");
    }

    public void shutdown() {
        System.out.println("计算机关闭开始");
        cpu.shutdown();
        memory.shutdown();
        hardDrive.shutdown();
        System.out.println("计算机关闭完成");
    }
}
