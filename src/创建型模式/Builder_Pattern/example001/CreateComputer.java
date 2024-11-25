package 创建型模式.Builder_Pattern.example001;

public class CreateComputer {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Computer computer = director.construct("i7-6700","三星DDR4");
        // 可以在这里打印或使用构建好的计算机对象
        System.out.println(computer);
    }
}

class Computer{
    private String cpu;
    private String memory;

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + cpu + ", Memory=" + memory + "]";
    }
}

abstract class Builder{
    public abstract void buildCpu(String cpu);
    public abstract void buildMemory(String memory);
    public abstract Computer create();
}

class ConcreteBuilder extends Builder{
    private Computer computer = new Computer();

    @Override
    public void buildCpu(String cpu) {
        computer.setCpu(cpu);
    }

    @Override
    public void buildMemory(String memory) {
        computer.setMemory(memory);
    }

    @Override
    public Computer create() {
        return computer;
    }
}

class Director{
    private Builder builder = null;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Computer construct(String cpu, String memory){
        builder.buildCpu(cpu);
        builder.buildMemory(memory);
        return builder.create();  // 返回构建好的Computer对象
    }
}
