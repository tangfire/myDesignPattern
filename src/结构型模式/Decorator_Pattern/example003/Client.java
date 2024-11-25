package 结构型模式.Decorator_Pattern.example003;

// 客户端代码
public class Client {
    public static void main(String[] args) {
        Coffee espresso = new Espresso();
        System.out.println(espresso.getDescription() + " - Cost: $" + espresso.getCost());

        Coffee latteWithMilk = new MilkDecorator(new Latte());
        System.out.println(latteWithMilk.getDescription() + " - Cost: $" + latteWithMilk.getCost());

        Coffee latteWithMilkAndSyrup = new SyrupDecorator(new MilkDecorator(new Latte()));
        System.out.println(latteWithMilkAndSyrup.getDescription() + " - Cost: $" + latteWithMilkAndSyrup.getCost());
    }
}

// 咖啡接口
interface Coffee {
    String getDescription();
    double getCost();
}

// 浓缩咖啡类
class Espresso implements Coffee {
    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public double getCost() {
        return 2.0;
    }
}

// 拿铁咖啡类
class Latte implements Coffee {
    @Override
    public String getDescription() {
        return "Latte";
    }

    @Override
    public double getCost() {
        return 3.0;
    }
}

// 咖啡装饰器类
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }
}

// 牛奶装饰器类
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 1.0;
    }
}

// 糖浆装饰器类
class SyrupDecorator extends CoffeeDecorator {
    public SyrupDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Syrup";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.5;
    }
}

