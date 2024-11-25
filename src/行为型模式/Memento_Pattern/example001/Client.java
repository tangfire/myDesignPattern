package 行为型模式.Memento_Pattern.example001;

public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        // 设置初始状态
        originator.setState("state-1 attack = 100");
        System.out.println("current state = " + originator.getState());

        // 将当前状态保存到备忘录中
        caretaker.setMemento(originator.createMemento());

        // 修改状态
        originator.setState("state-2 attack = 80");
        System.out.println("current state = " + originator.getState());

        // 恢复到上一个状态
        System.out.println("Undo to previous state:");
        originator.setMemento(caretaker.getMemento());
        System.out.println("current state = " + originator.getState());
    }
}

// Memento 类，保存 Originator 的状态
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// Originator 类，负责创建和恢复备忘录
class Originator {
    private String state;

    // 设置状态
    public void setState(String state) {
        this.state = state;
    }

    // 获取状态
    public String getState() {
        return state;
    }

    // 创建备忘录
    public Memento createMemento() {
        return new Memento(state);
    }

    // 恢复状态
    public void setMemento(Memento memento) {
        this.state = memento.getState();
    }
}

// Caretaker 类，负责保存备忘录
class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}




