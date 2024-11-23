package example02;

public class Client {
    public static void main(String[] args) {
        Target t = new Adapter();
        t.request();
    }
}

interface Target{
    public void request();
}

class Adaptee{
    public void specificRequest() {
        System.out.println("specificRequest");
    }
}

class Adapter extends Adaptee implements Target{
    public void request() {
        System.out.println("request");
    }
}




