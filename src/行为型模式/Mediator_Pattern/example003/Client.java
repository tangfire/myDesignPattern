package 行为型模式.Mediator_Pattern.example003;

// 客户端代码
public class Client {
    public static void main(String[] args) {
        ChatMediator chatMediator = new ChatRoom();

        User user1 = new User("User 1", chatMediator);
        User user2 = new User("User 2", chatMediator);

        user1.sendMessage("Hello!");
        user2.sendMessage("Hi!");
    }
}

// 中介者接口
interface ChatMediator {
    void sendMessage(User sender, String message);
}


// 具体的中介者类
class ChatRoom implements ChatMediator {
    @Override
    public void sendMessage(User sender, String message) {
        System.out.println(sender.getName() + " sends message: " + message);
    }
}


// 用户类
class User {
    private String name;
    private ChatMediator chatMediator;

    public User(String name, ChatMediator chatMediator) {
        this.name = name;
        this.chatMediator = chatMediator;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message) {
        chatMediator.sendMessage(this, message);
    }
}

