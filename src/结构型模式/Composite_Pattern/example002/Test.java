package 结构型模式.Composite_Pattern.example002;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Component root = new Composite("Root");

        Component node1 = new Composite("Node1");
        node1.add(new Leaf("Leaf1"));
        node1.add(new Leaf("Leaf2"));

        Component node2 = new Composite("Node2");
        node2.add(new Leaf("Leaf3"));

        root.add(node1);
        root.add(node2);

        root.display();
        // 输出：
        // Root
        // Node1
        // Leaf1
        // Leaf2
        // Node2
        // Leaf3

    }
}



abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void add(Component component);
    public abstract void remove(Component component);
    public abstract void display();
}

class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("Leaf cannot add component.");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Leaf cannot remove component.");
    }

    @Override
    public void display() {
        System.out.println(name);
    }
}

class Composite extends Component {
    private List<Component> components = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public void display() {
        System.out.println(name);
        for (Component component : components) {
            component.display();
        }
    }
}



