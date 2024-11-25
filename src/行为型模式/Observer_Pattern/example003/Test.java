package 行为型模式.Observer_Pattern.example003;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        Observer observer1 = new ConcreteObserver("Observer1");
        Observer observer2 = new ConcreteObserver("Observer2");

        subject.addObserver(observer1);
        subject.addObserver(observer2);

        subject.notifyObservers("新消息：这是一条观察者模式的示例");
        // 输出：
        // Observer1 收到消息：新消息：这是一条观察者模式的示例
        // Observer2 收到消息：新消息：这是一条观察者模式的示例

    }
}



interface Observer {
    void update(String message);
}

class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " 收到消息：" + message);
    }
}

interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}

class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

