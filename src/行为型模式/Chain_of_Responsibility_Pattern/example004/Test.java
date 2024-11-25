package 行为型模式.Chain_of_Responsibility_Pattern.example004;

public class Test {
    public static void main(String[] args) {
        Postman beijingPostman = new BeijingPostman();
        Postman guangzhouPostman = new GuangZhouPostman();
        beijingPostman.nextPostman = guangzhouPostman;
        beijingPostman.handleCourier("Guangzhou"); // 期望输出: "派送到广州"
        beijingPostman.handleCourier("Shanghai"); // 期望输出: "无处理者"
    }
}

abstract class Postman {
    protected Postman nextPostman;
    public abstract void handleCourier(String address);
}

class BeijingPostman extends Postman {
    @Override
    public void handleCourier(String address) {
        if (address.equals("Beijing")) {
            System.out.println("派送到北京");
        } else {
            if (nextPostman != null) {
                nextPostman.handleCourier(address);
            } else {
                System.out.println("没有处理者处理该请求: " + address);
            }
        }
    }
}

class GuangZhouPostman extends Postman {
    @Override
    public void handleCourier(String address) {
        if (address.equals("Guangzhou")) {
            System.out.println("派送到广州");
        } else {
            if (nextPostman != null) {
                nextPostman.handleCourier(address);
            } else {
                System.out.println("没有处理者处理该请求: " + address);
            }
        }
    }
}
