package 行为型模式.Observer_Pattern.example001;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Subject postman = new Postman();
        Observer boy = new Boy("李飞");
        Observer girl = new Girl("小美");
        postman.add(boy);
        postman.add(girl);
        postman.notify("快递到了，请下楼领取");

    }
}

interface Observer{
    public void update(String message);
}


class Boy implements Observer{
    private String name;
    public Boy(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "收到了信息:" + message + ",然后去取快递");
    }
}


class Girl implements Observer{
    private String name;
    public Girl(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "收到了信息:" +message+ ",然后让男朋友去取快递");
    }
}

interface Subject{
    void add(Observer observer);
    void remove(Observer observer);
    void notify(String message);
}

class Postman implements Subject{
    private List<Observer> personList = new ArrayList<Observer>();

    @Override
    public void remove(Observer observer) {
        personList.remove(observer);
    }

    @Override
    public void add(Observer observer) {
        personList.add(observer);
    }



    @Override
    public void notify(String message) {
        for(Observer observer : personList){
            observer.update(message);
        }
    }
}
