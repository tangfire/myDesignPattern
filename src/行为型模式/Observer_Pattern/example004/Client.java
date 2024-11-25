package 行为型模式.Observer_Pattern.example004;

import java.util.ArrayList;
import java.util.List;

// 客户端代码
public class Client {
    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");
        Observer observer3 = new ConcreteObserver("Observer 3");

        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.addObserver(observer3);

        subject.setState(1);
        subject.setState(2);
    }
}

// 观察者接口
interface Observer {
    void update(int state);
}


// 具体观察者类
class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(int state) {
        System.out.println(name + " received update. New state: " + state);
    }
}


// 主题类
class Subject {
    private int state;
    private List<Observer> observers;

    public Subject() {
        this.state = 0;
        this.observers = new ArrayList<>();
    }

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}

