package 行为型模式.Mediator_Pattern.example001;

public class Test {
    public static void main(String[] args) {
        Lianjia houseMediator = new Lianjia();
        Purchaser purchaser = new Purchaser(houseMediator);
        Landlord landlord = new Landlord(houseMediator);
        houseMediator.setLandlord(landlord);
        houseMediator.setPurchaser(purchaser);

        landlord.send("出售一套别墅");
        System.out.println("------------------------------------");
        purchaser.send("求购一套学区房");
    }
}

interface HouseMediator {
    void notice(Person person, String message);
}

abstract class Person {
    protected HouseMediator houseMediator;

    public Person(HouseMediator houseMediator) {
        this.houseMediator = houseMediator;
    }

    public abstract void send(String message);
    public abstract void getNotice(String message);
}

class Purchaser extends Person {
    public Purchaser(HouseMediator houseMediator) {
        super(houseMediator);
    }

    @Override
    public void send(String message) {
        System.out.println("买房者发布信息:" + message);
        houseMediator.notice(this, message);  // 通过中介者发送消息
    }

    @Override
    public void getNotice(String message) {
        System.out.println("买房者收到信息:" + message);
    }
}

class Landlord extends Person {
    public Landlord(HouseMediator houseMediator) {
        super(houseMediator);
    }

    @Override
    public void send(String message) {
        System.out.println("房东发布信息:" + message);
        houseMediator.notice(this, message);  // 通过中介者发送消息
    }

    @Override
    public void getNotice(String message) {
        System.out.println("房东收到信息:" + message);
    }
}

class Lianjia implements HouseMediator {
    Purchaser mPurchaser;
    Landlord mLandlord;

    public void setPurchaser(Purchaser purchaser) {
        mPurchaser = purchaser;
    }

    public void setLandlord(Landlord landlord) {
        mLandlord = landlord;
    }

    @Override
    public void notice(Person person, String message) {
        System.out.println("中介收到信息，并转发给相应的目标人群");
        if (person == mLandlord) {
            mPurchaser.getNotice(message);  // 如果是房东发送的消息，转发给买房者
        } else if (person == mPurchaser) {
            mLandlord.getNotice(message);  // 如果是买房者发送的消息，转发给房东
        }
    }
}
