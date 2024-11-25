package 创建型模式.Singleton_Pattern.example001;

/**
 * 懒汉式
 */
public class Client {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.doSomething();
    }
}


// 单例类
class Singleton {
    private static Singleton instance;

    // 私有构造函数，防止外部实例化
    private Singleton() {}

    // 全局访问点，获取唯一实例
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // 其他实例方法
    public void doSomething() {
        System.out.println("hello world");
    }
}

