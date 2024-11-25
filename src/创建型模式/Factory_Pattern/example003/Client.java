package 创建型模式.Factory_Pattern.example003;

public class Client {
    public static void main(String[] args) {
        LoggerFactory fileLoggerFactory = new FileLoggerFactory();
        Logger fileLogger = fileLoggerFactory.createLogger();
        fileLogger.log("这是文件日志记录");

        LoggerFactory databaseLoggerFactory = new DatabaseLoggerFactory();
        Logger databaseLogger = databaseLoggerFactory.createLogger();
        databaseLogger.log("这是数据库日志记录");

    }
}

// 抽象日志记录器接口
interface Logger {
    void log(String message);
}


// 具体文件日志记录器
class FileLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("记录日志到文件：" + message);
    }
}

// 具体数据库日志记录器
class DatabaseLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("记录日志到数据库：" + message);
    }
}


// 抽象日志记录器工厂接口
interface LoggerFactory {
    Logger createLogger();
}


// 具体文件日志记录器工厂
class FileLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        return new FileLogger();
    }
}

// 具体数据库日志记录器工厂
class DatabaseLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        return new DatabaseLogger();
    }
}

