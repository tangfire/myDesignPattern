# 23种设计模式

## 工厂方法模式

![](./src/example01/FactoryMethod.jpg)

```java
package example01;

/**
 * 工厂方法模式
 */
public class SimpleFactoryModel {
    public static void main(String[] args) {
        // 在工厂中进行产品的选择，而不需要客户端显式选择工厂
        Factory factory = new FactoryA(); // 或者通过某些条件来选择工厂
        Product instance = factory.createInstance();
        instance.info();

        factory = new FactoryB(); // 或者通过某些条件来选择不同的工厂
        instance = factory.createInstance();
        instance.info();
    }
}

interface Product {
    void info();
}

interface Factory {
    Product createInstance();
}

class FactoryA implements Factory {
    @Override
    public Product createInstance() {
        return new ProductA();
    }
}

class FactoryB implements Factory {
    @Override
    public Product createInstance() {
        return new ProductB();
    }
}

class ProductA implements Product {
    @Override
    public void info() {
        System.out.println("AAAAAAAAA");
    }
}

class ProductB implements Product {
    @Override
    public void info() {
        System.out.println("BBBBBBBBBBBB");
    }
}

```

## 抽象工厂模式

![](./src/example02/AbatractFactory.jpg)

```java
package example02;

/**
 * 抽象工厂设计模式
 * @author CZJ
 */
public class AbstractFactory {
    public static void main(String[] args) {
        // 使用工厂创建产品实例
        AbstractProductAA productAA = new CreateFactory().createProductAA();
        AbstractProductBB productBB = new CreateFactory().createProductBB();
        
        // 调用产品的方法
        productAA.infoA();
        productBB.infoB();
    }
}

// ProductAA1 实现了 AbstractProductAA 接口
class ProductAA1 implements AbstractProductAA {

    @Override
    public void infoA() {
        System.out.println("AA1的信息");
    }
}

// ProductBB1 实现了 AbstractProductBB 接口
class ProductBB1 implements AbstractProductBB {

    @Override
    public void infoB() {
        System.out.println("BB1的信息");
    }
}

// 抽象产品接口：ProductAA
interface AbstractProductAA {
    void infoA();
}

// 抽象产品接口：ProductBB
interface AbstractProductBB {
    void infoB();
}

// 具体工厂：CreateFactory 负责创建产品
class CreateFactory implements AllAbstractFactory {

    @Override
    public AbstractProductAA createProductAA() {
        return new ProductAA1();  // 返回实现了 AbstractProductAA 接口的对象
    }

    @Override
    public AbstractProductBB createProductBB() {
        return new ProductBB1();  // 返回实现了 AbstractProductBB 接口的对象
    }
}

// 总工厂接口：可以创建不同类型的产品
interface AllAbstractFactory {
    AbstractProductAA createProductAA();

    AbstractProductBB createProductBB();
}


```


## 建造者模式

![](./src/example03/Builder.jpg)

```java
package example03;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成器模式
 *
 * @author CZJ
 */
public class BuilderPattern {
    public static void main(String[] args) {
        Director director = new Director();
        ConcreteBuilder concreteBuilder = new ConcreteBuilder();
        director.construct(concreteBuilder);
        concreteBuilder.getResult().show();
    }
}

class Director {
    // 构建方法
    public void construct(Builder builder) {
        builder.buildPart();
    }
}

class ConcreteBuilder extends Builder {
    private Product product = new Product();

    @Override
    void buildPart() {
        product.add("A");
        product.add("B");
        product.add("C");
        product.add("D");
        product.add("E");
    }

    @Override
    Product getResult() {
        return product;
    }
}

abstract class Builder {
    // 添加产品构件
    abstract void buildPart();

    // 输出产品
    abstract Product getResult();
}

class Product {
    // 产品中可能存在的构件的集合
    private List<String> list = new ArrayList<>();

    // 添加构建方法
    public void add(String componentName) {
        list.add(componentName);
    }

    // 输出产品的具体信息
    public void show() {
        System.out.println("该产品有以下构件:\n");
        for (String component : list) {
            System.out.println(component);
        }
    }
}

```
