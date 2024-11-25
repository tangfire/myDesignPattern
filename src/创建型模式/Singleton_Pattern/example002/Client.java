package 创建型模式.Singleton_Pattern.example002;

/**
 * 饿汉式
 */
public class Client {
    public static void main(String[] args) {
        ESingleton esingleton = ESingleton.getInstance();
        esingleton.doSomething();
    }
}

// 单例类
class ESingleton {
    private static final ESingleton instance = new ESingleton();

    // 私有构造函数，防止外部实例化
    private ESingleton() {}

    // 全局访问点，获取唯一实例
    public static  ESingleton getInstance() {
        return instance;
    }


    // 其他实例方法
    public void doSomething() {
        System.out.println("hello world");
    }
}
