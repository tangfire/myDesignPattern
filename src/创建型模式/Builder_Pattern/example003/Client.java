package 创建型模式.Builder_Pattern.example003;

// 客户端代码
public class Client {
    public static void main(String[] args) {
        ComputerBuilder builder = new ComputerBuilder();

        builder.buildCpu("Intel i7");
        builder.buildMemory("16GB");
        builder.buildHardDisk("1TB");

        Computer computer = builder.getResult();
        System.out.println(computer.getConfiguration()); // 输出：CPU：Intel i7，内存：16GB，硬盘：1TB
    }
}


// 电脑类
class Computer {
    private String cpu;
    private String memory;
    private String hardDisk;

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getConfiguration() {
        return "CPU：" + cpu + "，内存：" + memory + "，硬盘：" + hardDisk;
    }
}

// 电脑建造者类
class ComputerBuilder {
    private Computer computer = new Computer();

    public void buildCpu(String cpu) {
        computer.setCpu(cpu);
    }

    public void buildMemory(String memory) {
        computer.setMemory(memory);
    }

    public void buildHardDisk(String hardDisk) {
        computer.setHardDisk(hardDisk);
    }

    public Computer getResult() {
        return computer;
    }
}
