package 结构型模式.Decorator_Pattern.example002;

public class Test {
    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println("原味咖啡：" + simpleCoffee.getDescription() + "，价格：" + simpleCoffee.getCost() + "元");

        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println("加牛奶咖啡：" + milkCoffee.getDescription() + "，价格：" + milkCoffee.getCost() + "元");

    }
}

interface Coffee {
    double getCost();
    String getDescription();
}

class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 5.0;
    }

    @Override
    public String getDescription() {
        return "普通咖啡";
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "，加牛奶";
    }
}

