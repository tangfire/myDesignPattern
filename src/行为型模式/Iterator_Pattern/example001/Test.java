package 行为型模式.Iterator_Pattern.example001;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Aggregate aggregate = new DeliverAggregate();
        aggregate.add("1111");
        aggregate.add("2222");
        Iterator iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            String tel = (String) iterator.next();
            System.out.println("current num = " + tel);
        }
        System.out.println("end!!!");
    }
}

interface Iterator {
    boolean hasNext();
    Object next();
}

interface Aggregate {
    String get(int location);
    void add(String tel);
    Iterator iterator();
    int size();  // 新增 size 方法
}

class DeliverIterator implements Iterator {
    private Aggregate aggregate;
    private int index = 0;


    public DeliverIterator(Aggregate aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public boolean hasNext() {
        return index < aggregate.size();  // 使用新的 size() 方法
    }

    @Override
    public Object next() {
        return aggregate.get(index++);
    }
}

class DeliverAggregate implements Aggregate {
    private List<String> list = new ArrayList<>();

    @Override
    public String get(int location) {
        return list.get(location);
    }

    @Override
    public void add(String tel) {
        list.add(tel);
    }

    @Override
    public Iterator iterator() {
        return new DeliverIterator(this);
    }

    @Override
    public int size() {
        return list.size();  // 返回 List 的大小
    }
}
