package 行为型模式.Chain_of_Responsibility_Pattern.example002;

public class Test {
    public static void main(String[] args) {
        Logger consoleLogger = new ConsoleLogger(Logger.INFO);
        Logger fileLogger = new FileLogger(Logger.DEBUG);
        Logger emailLogger = new EmailLogger(Logger.ERROR);

        consoleLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(emailLogger);

        consoleLogger.logMessage(Logger.INFO, "这是一条普通信息"); // 输出：控制台日志：这是一条普通信息
        consoleLogger.logMessage(Logger.DEBUG, "这是一条调试信息"); // 输出：控制台日志：这是一条调试信息，文件日志：这是一条调试信息
        consoleLogger.logMessage(Logger.ERROR, "这是一条错误信息"); // 输出：控制台日志：这是一条错误信息，文件日志：这是一条错误信息，电子邮件日志：这是一条错误信息
    }
}

abstract class Logger {
    // 定义日志级别常量
    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int ERROR = 3;

    protected int level;
    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    protected abstract void write(String message);
}

class ConsoleLogger extends Logger {
    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("控制台日志：" + message);
    }
}

class FileLogger extends Logger {
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("文件日志：" + message);
    }
}

class EmailLogger extends Logger {
    public EmailLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("电子邮件日志：" + message);
    }
}


