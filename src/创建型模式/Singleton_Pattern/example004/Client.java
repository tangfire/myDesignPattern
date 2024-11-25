package 创建型模式.Singleton_Pattern.example004;

/**
 * 懒汉式（优化版，使用双重检查锁）
 */
public class Client {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.doSomething();
    }
}

// 单例类
class Singleton {
    private static volatile Singleton instance;

    // 私有构造函数，防止外部实例化
    private Singleton() {}

    // 全局访问点，获取唯一实例
    public static Singleton getInstance() {
        if (instance == null) {  // 第一重检查
            synchronized (Singleton.class) {
                if (instance == null) {  // 第二重检查
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // 其他实例方法
    public void doSomething() {
        System.out.println("hello world");
    }
}
