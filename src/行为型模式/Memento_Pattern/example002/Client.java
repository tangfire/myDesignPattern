package 行为型模式.Memento_Pattern.example002;

import java.util.ArrayList;
import java.util.List;

// Memento 类，保存 Originator 的状态
class Memento {
    private String state;

    // 构造函数，用于保存状态
    public Memento(String state) {
        this.state = state;
    }

    // 仅允许 Originator 获取状态
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

    // 获取当前状态
    public String getState() {
        return state;
    }

    // 创建备忘录：将当前状态保存到备忘录对象中
    public Memento createMemento() {
        return new Memento(state);
    }

    // 恢复状态：通过备忘录恢复到之前保存的状态
    public void setMemento(Memento memento) {
        this.state = memento.getState();
    }
}

// Caretaker 类，负责管理多个备忘录
class Caretaker {
    private List<Memento> mementoHistory;  // 用于保存多个备忘录

    public Caretaker() {
        mementoHistory = new ArrayList<>();
    }

    // 保存备忘录
    public void addMemento(Memento memento) {
        mementoHistory.add(memento);
    }

    // 获取备忘录（按索引）
    public Memento getMemento(int index) {
        if (index >= 0 && index < mementoHistory.size()) {
            return mementoHistory.get(index);
        }
        return null;
    }

    // 获取所有备忘录的历史记录（方便调试）
    public List<Memento> getAllMementos() {
        return mementoHistory;
    }

    // 获取备忘录的数量
    public int getHistorySize() {
        return mementoHistory.size();
    }
}

// Client 类，展示如何使用备忘录模式
public class Client {
    public static void main(String[] args) {
        // 创建 Originator 和 Caretaker 实例
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        // 设置初始状态
        originator.setState("state-1 attack = 100");
        System.out.println("Current state: " + originator.getState());

        // 将当前状态保存到备忘录中
        caretaker.addMemento(originator.createMemento());

        // 修改状态
        originator.setState("state-2 attack = 80");
        System.out.println("Current state: " + originator.getState());

        // 再次保存备忘录
        caretaker.addMemento(originator.createMemento());

        // 修改状态
        originator.setState("state-3 attack = 50");
        System.out.println("Current state: " + originator.getState());

        // 再次保存备忘录
        caretaker.addMemento(originator.createMemento());

        // 输出所有备忘录历史
        System.out.println("\nCaretaker's memento history:");
        for (int i = 0; i < caretaker.getHistorySize(); i++) {
            System.out.println("Memento " + (i + 1) + ": " + caretaker.getMemento(i).getState());
        }

        // 恢复到上一个状态
        System.out.println("\nUndo to previous state:");
        originator.setMemento(caretaker.getMemento(1));  // 恢复到备忘录2
        System.out.println("Current state: " + originator.getState());

        // 恢复到最初的状态
        System.out.println("\nUndo to the first state:");
        originator.setMemento(caretaker.getMemento(0));  // 恢复到备忘录1
        System.out.println("Current state: " + originator.getState());
    }
}
