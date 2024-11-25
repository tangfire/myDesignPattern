package 行为型模式.Chain_of_Responsibility_Pattern.example003;

// 客户端代码
public class Client {
    public static void main(String[] args) {
        Approver manager = new Manager();
        Approver director = new Director();

        manager.setNextApprover(director);

        double amount1 = 800;
        double amount2 = 3000;
        double amount3 = 7000;

        manager.approve(amount1);
        manager.approve(amount2);
        System.out.println("---------------------------------");
        manager.approve(amount3);
    }
}

// 抽象审批者类
abstract class Approver {
    protected Approver nextApprover;

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public abstract void approve(double amount);
}


// 经理审批者类
class Manager extends Approver {
    @Override
    public void approve(double amount) {
        if (amount <= 1000) {
            System.out.println("Manager approved the purchase.");
        } else if (nextApprover != null) {
            nextApprover.approve(amount);
        }
    }
}

// 总监审批者类
class Director extends Approver {
    @Override
    public void approve(double amount) {
        if (amount <= 5000) {
            System.out.println("Director approved the purchase.");
        } else if (nextApprover != null) {
            nextApprover.approve(amount);
        }
    }
}

