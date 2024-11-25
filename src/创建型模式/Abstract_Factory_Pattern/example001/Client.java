package 创建型模式.Abstract_Factory_Pattern.example001;

// 客户端代码
public class Client {
    public static void main(String[] args) {
        GUIFactory windowsFactory = new WindowsGUIFactory();
        Button windowsButton = windowsFactory.createButton();
        TextField windowsTextField = windowsFactory.createTextField();

        GUIFactory macFactory = new MacGUIFactory();
        Button macButton = macFactory.createButton();
        TextField macTextField = macFactory.createTextField();

        windowsButton.render(); // 输出：渲染Windows风格的按钮
        windowsTextField.display(); // 输出：显示Windows风格的文本框

        macButton.render(); // 输出：渲染Mac风格的按钮
        macTextField.display(); // 输出：显示Mac风格的文本框
    }
}

// 抽象按钮接口
interface Button {
    void render();
}

// 抽象文本框接口
interface TextField {
    void display();
}


// Windows 风格按钮实现
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("渲染Windows风格的按钮");
    }
}

// Windows 风格文本框实现
class WindowsTextField implements TextField {
    @Override
    public void display() {
        System.out.println("显示Windows风格的文本框");
    }
}

// Mac 风格按钮实现
class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("渲染Mac风格的按钮");
    }
}

// Mac 风格文本框实现
class MacTextField implements TextField {
    @Override
    public void display() {
        System.out.println("显示Mac风格的文本框");
    }
}

// 抽象工厂接口
interface GUIFactory {
    Button createButton();
    TextField createTextField();
}

// Windows 风格工厂实现
class WindowsGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public TextField createTextField() {
        return new WindowsTextField();
    }
}

// Mac 风格工厂实现
class MacGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public TextField createTextField() {
        return new MacTextField();
    }
}


