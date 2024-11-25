package 行为型模式.Interpreter_Pattern.example001;

public class Test {
    public static void main(String[] args) {
        Expression expression = new AddExpression(new NumberExpression(3), new MultiplyExpression(new NumberExpression(4), new NumberExpression(5)));
        int result = expression.interpret();
        System.out.println("表达式计算结果：" + result); // 输出：表达式计算结果：23

    }
}


interface Expression {
    int interpret();
}

class NumberExpression implements Expression {
    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}

class AddExpression implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public AddExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() + rightExpression.interpret();
    }
}

class MultiplyExpression implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public MultiplyExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() * rightExpression.interpret();
    }
}
