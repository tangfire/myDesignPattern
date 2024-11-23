package example03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Component university, cscollege, eecollege;
        university = new Composite("THU");
        cscollege = new Composite("CS");
        eecollege = new Composite("EE");

        university.add(cscollege);
        university.add(eecollege);
        cscollege.add(new Leaf("SE"));
        eecollege.add(new Leaf("EEI"));

        // 调用操作方法，输出各个节点的操作
        university.operation();
    }
}

abstract class Component {
    protected String name; // 设置为 protected，符合封装原则

    public Component(String name) {
        this.name = name;
    }

    public abstract void add(Component c);
    public abstract void remove(Component c);
    public abstract List<Component> getChildren(); // 方法名改为复数，符合集合语义
    public abstract void operation(); // 执行操作，展示组合模式的效果
}

class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component c) {
        throw new UnsupportedOperationException("Leaf node cannot add children");
    }

    @Override
    public void remove(Component c) {
        throw new UnsupportedOperationException("Leaf node cannot remove children");
    }

    @Override
    public List<Component> getChildren() {
        return Collections.emptyList(); // 叶节点没有子节点
    }

    @Override
    public void operation() {
        System.out.println("Leaf: " + name); // 叶节点的操作表现
    }
}

class Composite extends Component {
    private List<Component> children;

    public Composite(String name) {
        super(name);
        this.children = new ArrayList<>();
    }

    @Override
    public void add(Component c) {
        children.add(c);
    }

    @Override
    public void remove(Component c) {
        children.remove(c);
    }

    @Override
    public List<Component> getChildren() {
        return Collections.unmodifiableList(children); // 返回不可修改的列表
    }

    @Override
    public void operation() {
        System.out.println("Composite: " + name); // 组合节点的操作表现
        for (Component child : children) {
            child.operation(); // 递归调用子节点的操作
        }
    }
}
