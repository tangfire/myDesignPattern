package 结构型模式.Flyweight_Pattern.example001;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        BikeFactory bikeFactory = new BikeFactory();
        IBike ofo = bikeFactory.getBike("ofo");
        ofo.billing(2);
        IBike ofo1 = bikeFactory.getBike("ofo");
        ofo1.billing(3);
    }
}

interface IBike {
    void billing(int time);
}

class ShareBike implements IBike {
    private int price = 1;
    private int total;

    @Override
    public void billing(int time) {
        total += price * time;  // 累加费用
        System.out.println("骑车花费了" + total + "元!");
    }
}

class BikeFactory {
    private static Map<String, IBike> pool = new HashMap<String, IBike>();

    public IBike getBike(String name) {
        IBike bike = null;
        if (pool.containsKey(name)) {
            System.out.println("押金已交，直接用车 " + name);
            bike = pool.get(name);
        } else {
            bike = new ShareBike();
            pool.put(name, bike);
            System.out.println("交100押金, 可以用车了");
        }
        return bike;
    }
}
