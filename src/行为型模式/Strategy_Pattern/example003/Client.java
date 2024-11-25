package 行为型模式.Strategy_Pattern.example003;

// 客户端代码
public class Client {
    public static void main(String[] args) {
        double amount = 100.0;

        Order order1 = new Order(amount, new AlipayStrategy());
        order1.processPayment();

        Order order2 = new Order(amount, new WeChatPayStrategy());
        order2.processPayment();

        Order order3 = new Order(amount, new CreditCardPayStrategy());
        order3.processPayment();
    }
}

// 支付策略接口
interface PaymentStrategy {
    void pay(double amount);
}


// 支付宝支付策略类
class AlipayStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Alipay.");
    }
}

// 微信支付策略类
class WeChatPayStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via WeChat Pay.");
    }
}

// 信用卡支付策略类
class CreditCardPayStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Credit Card.");
    }
}

// 订单类
class Order {
    private double amount;
    private PaymentStrategy paymentStrategy;

    public Order(double amount, PaymentStrategy paymentStrategy) {
        this.amount = amount;
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment() {
        paymentStrategy.pay(amount);
    }
}

