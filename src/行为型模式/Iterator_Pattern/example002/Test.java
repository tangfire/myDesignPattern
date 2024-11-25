package 行为型模式.Iterator_Pattern.example002;

import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        MyList myList = new MyList();
        myList.add("元素1");
        myList.add("元素2");
        myList.add("元素3");

        Iterator<String> iterator = myList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // 输出：
        // 元素1
        // 元素2
        // 元素3

    }
}




class MyList implements Iterable<String> {
    private String[] elements;
    private int size;
    private int capacity;

    public MyList() {
        capacity = 10;
        elements = new String[capacity];
        size = 0;
    }

    public void add(String element) {
        if (size == capacity) {
            resize();
        }
        elements[size++] = element;
    }

    private void resize() {
        capacity *= 2;
        String[] newElements = new String[capacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    @Override
    public Iterator<String> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<String> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public String next() {
            return elements[index++];
        }
    }
}
