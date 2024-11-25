package 行为型模式.Visitor_Pattern.example003;

public class Main {
    public static void main(String[] args) {
        // 创建不同的形状
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        // 创建访问者
        Visitor areaCalculator = new AreaCalculator();
        Visitor drawingVisitor = new DrawingVisitor();

        // 使用访问者进行操作
        circle.accept(areaCalculator);
        rectangle.accept(areaCalculator);

        circle.accept(drawingVisitor);
        rectangle.accept(drawingVisitor);
    }
}

interface Shape {
    void accept(Visitor visitor);  // 接受一个访问者
}


class Circle implements Shape {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);  // 接受访问者，调用访问者的 visit 方法
    }
}

class Rectangle implements Shape {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);  // 接受访问者，调用访问者的 visit 方法
    }
}


interface Visitor {
    void visit(Circle circle);       // 针对圆形的操作
    void visit(Rectangle rectangle);  // 针对矩形的操作
}


class AreaCalculator implements Visitor {
    @Override
    public void visit(Circle circle) {
        System.out.println("计算圆形的面积");
        // 假设圆的半径为5
        double area = Math.PI * 5 * 5;
        System.out.println("圆形的面积是: " + area);
    }

    @Override
    public void visit(Rectangle rectangle) {
        System.out.println("计算矩形的面积");
        // 假设矩形的长宽分别为4和6
        double area = 4 * 6;
        System.out.println("矩形的面积是: " + area);
    }
}


class DrawingVisitor implements Visitor {
    @Override
    public void visit(Circle circle) {
        System.out.println("绘制圆形");
    }

    @Override
    public void visit(Rectangle rectangle) {
        System.out.println("绘制矩形");
    }
}

