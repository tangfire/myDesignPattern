package 创建型模式.Factory_Pattern.example002;

public class Test {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape circle = factory.createShape("circle");
        circle.draw(); // 输出：绘制圆形

        Shape rectangle = factory.createShape("rectangle");
        rectangle.draw(); // 输出：绘制矩形

    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("绘制圆形");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("绘制矩形");
    }
}

class ShapeFactory {
    public Shape createShape(String shapeType) {
        if ("circle".equalsIgnoreCase(shapeType)) {
            return new Circle();
        } else if ("rectangle".equalsIgnoreCase(shapeType)) {
            return new Rectangle();
        }
        return null;
    }
}


