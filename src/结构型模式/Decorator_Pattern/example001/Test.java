package 结构型模式.Decorator_Pattern.example001;

public class Test {
    public static void main(String[] args) {
        // 创建一个新的房间
        Room newRoom = new NewRoom();

        // 装饰房间，先装饰卧室，再装饰厨房
        Room bedroomRoom = new Bedroom(newRoom);
        bedroomRoom.fitment();  // 输出卧室装饰的效果

        System.out.println("----");

        Room kitchenRoom = new Kitchen(newRoom);
        kitchenRoom.fitment();  // 输出厨房装饰的效果

        System.out.println("----");

        // 多重装饰：先装饰卧室，再装饰厨房
        Room fullyDecoratedRoom = new Kitchen(new Bedroom(newRoom));
        fullyDecoratedRoom.fitment();  // 输出卧室和厨房都装饰后的效果
    }
}

abstract class Room {
    public abstract void fitment();
}

class NewRoom extends Room {
    @Override
    public void fitment() {
        System.out.println("This is a new room.");
    }
}

// 装饰器基类
abstract class RoomDecorator extends Room {
    protected Room room;  // 被装饰的房间

    public RoomDecorator(Room room) {
        this.room = room;
    }

    @Override
    public void fitment() {
        room.fitment();  // 调用被装饰对象的 fitment 方法
    }
}

// 卧室装饰器
class Bedroom extends RoomDecorator {
    public Bedroom(Room room) {
        super(room);
    }

    @Override
    public void fitment() {
        super.fitment();  // 调用房间的原始装饰
        addBedding();     // 添加卧室装饰
    }

    private void addBedding() {
        System.out.println("Bedroom added.");
    }
}

// 厨房装饰器
class Kitchen extends RoomDecorator {
    public Kitchen(Room room) {
        super(room);
    }

    @Override
    public void fitment() {
        super.fitment();  // 调用房间的原始装饰
        addKitchen();     // 添加厨房装饰
    }

    private void addKitchen() {
        System.out.println("Kitchen added.");
    }
}
