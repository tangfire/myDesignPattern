package 行为型模式.Iterator_Pattern.example003;

// 客户端代码
public class Client {
    public static void main(String[] args) {
        String[] data = {"A", "B", "C", "D", "E"};
        MyList myList = new MyList(data);

        System.out.println("Elements in MyList:");
        while (myList.hasNext()) {
            System.out.println(myList.next());
        }
    }
}

// 迭代器接口
interface Iterator {
    boolean hasNext();
    Object next();
}


// 列表类
class MyList implements Iterator {
    private String[] data;
    private int index;

    public MyList(String[] data) {
        this.data = data;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < data.length;
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return data[index++];
        }
        return null;
    }
}

