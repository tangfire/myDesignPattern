package 结构型模式.Adapter_Pattern.example002;

public class Test {
    public static void main(String[] args) {
        LegacyRectangle legacyRectangle = new LegacyRectangle();
        Rectangle rectangleAdapter = new LegacyRectangleAdapter(legacyRectangle);
        double area = rectangleAdapter.getArea();
        System.out.println("矩形的面积：" + area);

    }
}


class LegacyRectangle {
    public double calculateArea() {
        // 计算矩形面积的复杂逻辑
        return 0.0;
    }
}

interface Rectangle {
    double getArea();
}

class LegacyRectangleAdapter implements Rectangle {
    private LegacyRectangle legacyRectangle;

    public LegacyRectangleAdapter(LegacyRectangle legacyRectangle) {
        this.legacyRectangle = legacyRectangle;
    }

    @Override
    public double getArea() {
        return legacyRectangle.calculateArea();
    }
}

