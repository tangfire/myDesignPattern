package 创建型模式.Abstract_Factory_Pattern.example002;

public class Test {
    public static void main(String[] args) {
        ComputerFactory lenovoComputerFactory = new LenovoComputerFactory();
        lenovoComputerFactory.createCpu().showCpu();
        lenovoComputerFactory.createMemory().showMemory();
        ComputerFactory asusComputerFactory = new AsusComputerFactory();
        asusComputerFactory.createCpu().showCpu();
        asusComputerFactory.createMemory().showMemory();
    }
}

abstract class Cpu{
    public abstract void showCpu();
}

abstract class Memory{
    public abstract void showMemory();
}

class IntelCpu extends Cpu{
    @Override
    public void showCpu() {
        System.out.println("Intel CPU");
    }
}

class AmdCpu extends Cpu{
    @Override
    public void showCpu() {
        System.out.println("Amd Cpu");
    }
}

class SamsungMemory extends Memory{
    @Override
    public void showMemory() {
        System.out.println("三星 内存");
    }
}

class KingstonMemory extends Memory{
    @Override
    public void showMemory() {
        System.out.println("金士顿 内存");
    }
}


abstract class ComputerFactory{
    public abstract Cpu createCpu();
    public abstract Memory createMemory();
}


class LenovoComputerFactory extends ComputerFactory{
    @Override
    public Cpu createCpu() {
        return new IntelCpu();
    }

    @Override
    public Memory createMemory() {
        return new SamsungMemory();
    }
}


class AsusComputerFactory extends ComputerFactory{
    @Override
    public Cpu createCpu() {
        return new AmdCpu();
    }

    @Override
    public Memory createMemory() {
        return new KingstonMemory();
    }
}