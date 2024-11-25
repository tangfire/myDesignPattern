package 行为型模式.Observer_Pattern.example002;

import java.util.ArrayList;
import java.util.List;


// 测试观察者模式
public class ObserverPatternDemo {
    public static void main(String[] args) {
        // 创建被观察者
        ConcreteSubject subject = new ConcreteSubject();

        // 创建观察者
        ConcreteObserver observer1 = new ConcreteObserver("观察者1");
        ConcreteObserver observer2 = new ConcreteObserver("观察者2");
        ConcreteObserver observer3 = new ConcreteObserver("观察者3");

        // 添加观察者
        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.addObserver(observer3);

        // 改变被观察者的状态
        System.out.println("改变状态为: 状态1");
        subject.setState("状态1");

        // 删除一个观察者
        subject.removeObserver(observer2);

        // 改变被观察者的状态
        System.out.println("\n改变状态为: 状态2");
        subject.setState("状态2");
    }
}


// 观察者接口
interface Observer {
    void update(String message);
}

// 具体观察者类
class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " 收到更新: " + message);
    }
}

// 被观察者接口
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// 具体被观察者类
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

    public String getState() {
        return state;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}

