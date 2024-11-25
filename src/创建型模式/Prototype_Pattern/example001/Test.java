package 创建型模式.Prototype_Pattern.example001;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Shape circle = new Circle();
        Shape clonedCircle = (Shape) circle.clone();
        clonedCircle.draw(); // 输出：绘制圆形

        Shape rectangle = new Rectangle();
        Shape clonedRectangle = (Shape) rectangle.clone();
        clonedRectangle.draw(); // 输出：绘制矩形
    }
}

abstract class Shape implements Cloneable {
    protected String type;

    public abstract void draw();

    public String getType() {
        return type;
    }

    // clone 方法声明抛出 CloneNotSupportedException
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Circle extends Shape {
    public Circle() {
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("绘制圆形");
    }
}

class Rectangle extends Shape {
    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("绘制矩形");
    }
}
