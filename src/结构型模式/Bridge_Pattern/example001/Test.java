package 结构型模式.Bridge_Pattern.example001;

public class Test {
    public static void main(String[] args) {
        Color redColor = new RedColor();
        Color greenColor = new GreenColor();

        Shape redCircle = new Circle(redColor);
        Shape greenSquare = new Square(greenColor);

        redCircle.applyColor(); // 输出：圆形 应用红色
        greenSquare.applyColor(); // 输出：矩形 应用绿色

    }
}


interface Color {
    void applyColor();
}

class RedColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("应用红色");
    }
}

class GreenColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("应用绿色");
    }
}

abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void applyColor();
}

class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.print("圆形 ");
        color.applyColor();
    }
}

class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.print("矩形 ");
        color.applyColor();
    }
}
