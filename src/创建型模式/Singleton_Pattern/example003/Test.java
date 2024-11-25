package 创建型模式.Singleton_Pattern.example003;

public class Test {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("这是一条日志信息");

    }
}

class Logger {
    private static Logger instance;

    private Logger() {
        // 私有构造方法
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("日志记录：" + message);
    }
}

