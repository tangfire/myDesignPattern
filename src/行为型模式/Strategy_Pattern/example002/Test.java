package 行为型模式.Strategy_Pattern.example002;

public class Test {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9012-3456", "John Doe");
        shoppingCart.setPaymentStrategy(creditCardPayment);
        shoppingCart.checkout(1000);
        // 输出：使用信用卡支付：1000.0，卡号：1234-5678-9012-3456，持卡人：John Doe

        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com");
        shoppingCart.setPaymentStrategy(payPalPayment);
        shoppingCart.checkout(500);
        // 输出：使用PayPal支付：500.0，邮箱：john.doe@example.com


    }
}

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String name;

    public CreditCardPayment(String cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }

    @Override
    public void pay(double amount) {
        System.out.println("使用信用卡支付：" + amount + "，卡号：" + cardNumber + "，持卡人：" + name);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("使用PayPal支付：" + amount + "，邮箱：" + email);
    }
}

class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount) {
        paymentStrategy.pay(amount);
    }
}



