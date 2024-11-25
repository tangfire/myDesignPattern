package 行为型模式.Interpreter_Pattern.example002;

import java.util.HashMap;
import java.util.Map;

// 客户端代码
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setValue("x", 10);
        context.setValue("y", 5);

        Expression addExpression = new AddExpression("x", 5);
        Expression subtractExpression = new SubtractExpression("y", 2);

        int result1 = addExpression.interpret(context);
        int result2 = subtractExpression.interpret(context);

        System.out.println("Result of x + 5: " + result1); // 输出：Result of x + 5: 15
        System.out.println("Result of y - 2: " + result2); // 输出：Result of y - 2: 3
    }
}

// 抽象表达式类
interface Expression {
    int interpret(Context context);
}

// 加法表达式类
class AddExpression implements Expression {
    private String variable;
    private int value;

    public AddExpression(String variable, int value) {
        this.variable = variable;
        this.value = value;
    }

    @Override
    public int interpret(Context context) {
        return context.getValue(variable) + value;
    }
}

// 减法表达式类
class SubtractExpression implements Expression {
    private String variable;
    private int value;

    public SubtractExpression(String variable, int value) {
        this.variable = variable;
        this.value = value;
    }

    @Override
    public int interpret(Context context) {
        return context.getValue(variable) - value;
    }
}

// 上下文类
class Context {
    private Map<String, Integer> variables;

    public Context() {
        this.variables = new HashMap<>();
    }

    public void setValue(String variable, int value) {
        variables.put(variable, value);
    }

    public int getValue(String variable) {
        return variables.getOrDefault(variable, 0);
    }
}

