package 创建型模式.Factory_Pattern.example001;

public class Test {
    public static void main(String[] args) {
        Factory factoryA = new FactoryA();
        Product productA =  factoryA.create();
        productA.show();
        Factory factoryB = new FactoryB();
        Product productB =  factoryB.create();
        productB.show();

    }
}

abstract class Product{
    public abstract void show();
}

class ProductA extends Product{
    @Override
    public void show() {
        System.out.println("Product A");
    }
}



class ProductB extends Product{
    @Override
    public void show() {
        System.out.println("Product B");
    }
}


abstract class Factory{
    public abstract Product create();
}


class FactoryA extends Factory{
    @Override
    public Product create() {
        return new ProductA();
    }
}


class FactoryB extends Factory{
    @Override
    public Product create() {
        return new ProductB();
    }
}

