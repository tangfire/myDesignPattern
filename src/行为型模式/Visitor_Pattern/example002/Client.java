package 行为型模式.Visitor_Pattern.example002;

// 客户端代码
public class Client {
    public static void main(String[] args) {
        ElementA elementA = new ElementA();
        ElementB elementB = new ElementB();

        Visitor visitor = new ConcreteVisitor();

        elementA.accept(visitor); // 输出：执行元素A的操作
        elementB.accept(visitor); // 输出：执行元素B的操作
    }
}

// 访问者接口
interface Visitor {
    void visitElementA(ElementA elementA);
    void visitElementB(ElementB elementB);
}


// 元素接口
interface Element {
    void accept(Visitor visitor);
}


// 具体元素类 ElementA
class ElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitElementA(this);
    }

    // 元素A特有的操作
    void operationA() {
        System.out.println("执行元素A的操作");
    }
}

// 具体元素类 ElementB
class ElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitElementB(this);
    }

    // 元素B特有的操作
    void operationB() {
        System.out.println("执行元素B的操作");
    }
}


// 具体访问者类 ConcreteVisitor
class ConcreteVisitor implements Visitor {
    @Override
    public void visitElementA(ElementA elementA) {
        // 实现操作1，处理元素A
        elementA.operationA();
    }

    @Override
    public void visitElementB(ElementB elementB) {
        // 实现操作2，处理元素B
        elementB.operationB();
    }
}
