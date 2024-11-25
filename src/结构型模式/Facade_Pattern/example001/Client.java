package 结构型模式.Facade_Pattern.example001;

public class Client {
    public static void main(String[] args) {
        Facade f = new Facade();
        f.on();
    }


}

class subSystemA{
    public void on(){
        System.out.println("cpu运行");
    }

}

class subSystemB{
    public void on(){
        System.out.println("内存运行");
    }

}

class Facade{
    private subSystemA a;
    private subSystemB b;
    public Facade(){
        a = new subSystemA();
        b = new subSystemB();
    }

    public void on(){
        a.on();
        b.on();
    }
}

