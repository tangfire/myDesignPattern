package 行为型模式.Mediator_Pattern.example002;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        User user1 = new User("Alice", chatRoom);
        User user2 = new User("Bob", chatRoom);
        User user3 = new User("Charlie", chatRoom);

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);

        user1.sendMessage("大家好！");
        // 输出：
        // Bob 收到消息：Alice: 大家好！
        // Charlie 收到消息：Alice: 大家好！

    }
}



class User {
    private String name;
    private ChatRoom chatRoom;

    public User(String name, ChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }

    public void sendMessage(String message) {
        chatRoom.sendMessage(this, message);
    }

    public void receiveMessage(String message) {
        System.out.println(name + " 收到消息：" + message);
    }

    // 添加这个方法来返回用户的名字
    public String getName() {
        return name;
    }
}


class ChatRoom {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void sendMessage(User sender, String message) {
        for (User user : users) {
            if (user != sender) {
                user.receiveMessage(sender.getName() + ": " + message);
            }
        }
    }
}

