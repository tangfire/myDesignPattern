package 结构型模式.Bridge_Pattern.example003;

public class Client {
    public static void main(String[] args) {
        // 使用不同的实现
        Implementor a = new ConcreteImplementorA();
        Implementor b = new ConcreteImplementorB();

        // 使用抽象类结合具体实现
        Abstraction abstraction = new RefinedAbstraction(a);
        abstraction.operation();

        Abstraction abstraction2 = new RefinedAbstraction(b);
        abstraction2.operation();
    }
}

interface Implementor {
    // 定义操作接口
    void operationImpl();
}

abstract class Abstraction {
    protected Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    // 定义抽象的操作方法，具体业务可以在子类中实现
    abstract void operation();
}

class ConcreteImplementorA implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("用小米手机打电话");
    }
}

class ConcreteImplementorB implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("用苹果手机打电话");
    }
}

class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    void operation() {
        // 扩展操作，在调用具体实现之前可以增加其他业务逻辑
        System.out.println("使用平板打电话");
        implementor.operationImpl(); // 调用具体实现
    }
}
