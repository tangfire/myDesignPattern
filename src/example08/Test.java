package example08;

public class Test {
    public static void main(String[] args) {
        TravelContext context;

        // 使用火车策略
        context = new TravelContext(new TrainStrategy());
        context.travel();

        // 使用公交车策略
        context = new TravelContext(new BusStrategy());
        context.travel();
    }
}

// 策略接口
interface TravelStrategy {
    void travel();
}

// 火车旅行策略
class TrainStrategy implements TravelStrategy {
    @Override
    public void travel() {
        System.out.println("Train travel");
    }
}

// 公交车旅行策略
class BusStrategy implements TravelStrategy {
    @Override
    public void travel() {
        System.out.println("Bus travel");
    }
}

// 上下文类，管理策略
class TravelContext {
    private TravelStrategy strategy;

    public TravelContext(TravelStrategy strategy) {
        this.strategy = strategy;
    }

    public void travel() {
        strategy.travel();
    }
}
