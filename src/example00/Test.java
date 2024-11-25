package example00;

public class Test {
    public static void main(String[] args) {
        Factory.getProduct("A").show();
        Factory.getProduct("B").show();
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

class Factory{
    public static Product getProduct(String productName){
        Product product = null;
        switch (productName){
            case "A":
                product = new ProductA();
                break;
            case "B":
                product = new ProductB();
                break;
        }
        return product;
    }
}