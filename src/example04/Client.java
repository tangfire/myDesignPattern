package example04;

public class Client {
    public static void main(String[] args) {
        Subject subject = new Proxy();
        subject.request();
    }
}

abstract class Subject{
    public abstract void request();
}

class RealSubject extends Subject{
    @Override
    public void request() {
        System.out.println("request");
    }
}


class Proxy extends Subject{
    private RealSubject realSubject;
    public Proxy(){
        this.realSubject = new RealSubject();
    }

    public void preRequest(){
        System.out.println("preRequest");
    }

    public void postRequest(){
        System.out.println("postRequest");
    }

    @Override
    public void request() {
        preRequest();
        realSubject.request();
        postRequest();
    }
}


