package 结构型模式.Bridge_Pattern.example002;

// 客户端代码
public class Client {
    public static void main(String[] args) {
        DrawingAPI drawingAPI1 = new DrawingAPI1();
        DrawingAPI drawingAPI2 = new DrawingAPI2();

        Shape circle1 = new Circle(100, 100, 50, drawingAPI1);
        Shape circle2 = new Circle(200, 200, 100, drawingAPI2);

        Shape rectangle1 = new Rectangle(10, 20, 30, 40, drawingAPI1);
        Shape rectangle2 = new Rectangle(50, 60, 70, 80, drawingAPI2);

        circle1.draw();     // 输出：API1 Drawing Circle at (100,100) with radius 50
        circle2.draw();     // 输出：API2 Drawing Circle at (200,200) with radius 100
        rectangle1.draw();  // 输出：API1 Drawing Rectangle from (10,20) to (30,40)
        rectangle2.draw();  // 输出：API2 Drawing Rectangle from (50,60) to (70,80)
    }
}


// 抽象形状类
abstract class Shape {
    protected DrawingAPI drawingAPI;

    public Shape(DrawingAPI drawingAPI) {
        this.drawingAPI = drawingAPI;
    }

    public abstract void draw();
}


// 抽象绘图API
interface DrawingAPI {
    void drawCircle(int x, int y, int radius);
    void drawRectangle(int x1, int y1, int x2, int y2);
}



// 具体圆形类
class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawingAPI.drawCircle(x, y, radius);
    }
}

// 具体矩形类
class Rectangle extends Shape {
    private int x1, y1, x2, y2;

    public Rectangle(int x1, int y1, int x2, int y2, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw() {
        drawingAPI.drawRectangle(x1, y1, x2, y2);
    }
}


// 具体绘图API实现类1
class DrawingAPI1 implements DrawingAPI {
    @Override
    public void drawCircle(int x, int y, int radius) {
        System.out.println("API1 Drawing Circle at (" + x + "," + y + ") with radius " + radius);
    }

    @Override
    public void drawRectangle(int x1, int y1, int x2, int y2) {
        System.out.println("API1 Drawing Rectangle from (" + x1 + "," + y1 + ") to (" + x2 + "," + y2 + ")");
    }
}

// 具体绘图API实现类2
class DrawingAPI2 implements DrawingAPI {
    @Override
    public void drawCircle(int x, int y, int radius) {
        System.out.println("API2 Drawing Circle at (" + x + "," + y + ") with radius " + radius);
    }

    @Override
    public void drawRectangle(int x1, int y1, int x2, int y2) {
        System.out.println("API2 Drawing Rectangle from (" + x1 + "," + y1 + ") to (" + x2 + "," + y2 + ")");
    }
}
