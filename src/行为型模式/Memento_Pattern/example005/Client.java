package 行为型模式.Memento_Pattern.example005;

// 客户端代码
public class Client {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();

        textEditor.setText("Hello, World!");
        Memento memento = textEditor.save();

        textEditor.setText("Goodbye, World!");
        System.out.println("Current text: " + textEditor.getText());

        textEditor.restore(memento);
        System.out.println("Restored text: " + textEditor.getText());
    }
}

// 备忘录类
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}


// 文本编辑器类（原始对象）
class TextEditor {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Memento save() {
        return new Memento(text);
    }

    public void restore(Memento memento) {
        text = memento.getState();
    }
}

