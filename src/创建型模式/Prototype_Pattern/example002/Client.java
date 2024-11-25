package 创建型模式.Prototype_Pattern.example002;

// 客户端代码
public class Client {
    public static void main(String[] args) {
        Shape rectangle1 = new Rectangle();
        Shape rectangle2 = rectangle1.cloneShape();

        Shape circle1 = new Circle();
        Shape circle2 = circle1.cloneShape();

        System.out.println(rectangle1.getType()); // 输出：Rectangle
        System.out.println(rectangle2.getType()); // 输出：Rectangle

        System.out.println(circle1.getType());    // 输出：Circle
        System.out.println(circle2.getType());    // 输出：Circle
    }
}

// 抽象图形类
abstract class Shape implements Cloneable {
    private String type;

    public Shape(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    // 定义抽象的克隆方法
    public abstract Shape cloneShape();
}

// 具体矩形类
class Rectangle extends Shape {
    public Rectangle() {
        super("Rectangle");
    }

    @Override
    public Shape cloneShape() {
        try {
            return (Shape) super.clone();  // 使用super.clone()进行克隆
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

// 具体圆形类
class Circle extends Shape {
    public Circle() {
        super("Circle");
    }

    @Override
    public Shape cloneShape() {
        try {
            return (Shape) super.clone();  // 使用super.clone()进行克隆
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}



