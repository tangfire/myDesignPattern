package 行为型模式.Memento_Pattern.example003;

import java.util.Stack;

public class MementoPatternDemo {
    public static void main(String[] args) {
        // 创建一个游戏角色
        GameCharacter character = new GameCharacter("Hero", 100, 50);

        // 显示角色初始状态
        System.out.println("初始状态：");
        character.showState();

        // 创建备忘录管理对象
        GameHistory gameHistory = new GameHistory();

        // 保存当前状态
        gameHistory.save(character.saveState());

        // 角色受到伤害
        character.takeDamage(30);
        System.out.println("\n角色受到30点伤害后：");
        character.showState();

        // 保存当前状态
        gameHistory.save(character.saveState());

        // 角色增加攻击力
        character.increaseAttackPower(20);
        System.out.println("\n角色增加了攻击力后：");
        character.showState();

        // 恢复到上一个保存点（攻击力增加之前）
        character.restoreState(gameHistory.restore());
        System.out.println("\n恢复到增加攻击力之前的状态：");
        character.showState();

        // 恢复到初始状态（最开始的状态）
        character.restoreState(gameHistory.restore());
        System.out.println("\n恢复到初始状态：");
        character.showState();
    }
}


// 游戏角色类
class GameCharacter {
    private String name;
    private int health;
    private int attackPower;

    // 构造函数
    public GameCharacter(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    // 显示角色当前状态
    public void showState() {
        System.out.println(name + " [Health: " + health + ", AttackPower: " + attackPower + "]");
    }

    // 创建备忘录，将当前状态保存
    public Memento saveState() {
        return new Memento(name, health, attackPower);
    }

    // 恢复角色状态
    public void restoreState(Memento memento) {
        this.name = memento.getName();
        this.health = memento.getHealth();
        this.attackPower = memento.getAttackPower();
    }

    // 角色的一些改变方法（模拟游戏中的状态改变）
    public void takeDamage(int damage) {
        health -= damage;
    }

    public void increaseAttackPower(int increment) {
        attackPower += increment;
    }
}

// 备忘录类（保存角色状态的对象）
// 现在它是一个独立的类，不再是内部类
class Memento {
    private final String name;
    private final int health;
    private final int attackPower;

    public Memento(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }
}

// 游戏历史管理类，负责保存和恢复游戏角色的状态
class GameHistory {
    private Stack<Memento> history = new Stack<>();

    // 保存角色状态
    public void save(Memento memento) {
        history.push(memento);
    }

    // 恢复到最近的状态
    public Memento restore() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;  // 如果没有备份状态，返回null
    }
}
