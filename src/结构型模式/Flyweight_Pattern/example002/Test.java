package 结构型模式.Flyweight_Pattern.example002;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Player terrorist1 = PlayerFactory.getPlayer("Terrorist");
        Player terrorist2 = PlayerFactory.getPlayer("Terrorist");
        Player counterTerrorist1 = PlayerFactory.getPlayer("CounterTerrorist");
        Player counterTerrorist2 = PlayerFactory.getPlayer("CounterTerrorist");

        System.out.println(terrorist1 == terrorist2);
        System.out.println(counterTerrorist1 == counterTerrorist2);

        System.out.println("----------------------------");

        terrorist1.assignWeapon("AK-47");
        terrorist1.mission(); // 输出：Terrorist with weapon AK-47 | Performing mission...

        terrorist2.assignWeapon("Desert Eagle");
        terrorist2.mission(); // 输出：Terrorist with weapon Desert Eagle | Performing mission...

        counterTerrorist1.assignWeapon("M4A1");
        counterTerrorist1.mission(); // 输出：CounterTerrorist with weapon M4A1 | Performing mission...

        counterTerrorist2.assignWeapon("USP");
        counterTerrorist2.mission(); // 输出：CounterTerrorist with weapon USP | Performing mission...

    }
}

interface Player {
    void assignWeapon(String weapon);
    void mission();
}

class Terrorist implements Player {
    private final String TASK;

    private String weapon;

    public Terrorist() {
        TASK = "Terrorist";
    }

    @Override
    public void assignWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public void mission() {
        System.out.println(TASK + " with weapon " + weapon + " | Performing mission...");
    }
}

class CounterTerrorist implements Player {
    private final String TASK;

    private String weapon;

    public CounterTerrorist() {
        TASK = "CounterTerrorist";
    }

    @Override
    public void assignWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public void mission() {
        System.out.println(TASK + " with weapon " + weapon + " | Performing mission...");
    }
}

class PlayerFactory {
    private static Map<String, Player> players = new HashMap<>();

    public static Player getPlayer(String task) {
        Player player = players.get(task);

        if (player == null) {
            switch (task) {
                case "Terrorist":
                    System.out.println("Creating a Terrorist player");
                    player = new Terrorist();
                    break;
                case "CounterTerrorist":
                    System.out.println("Creating a CounterTerrorist player");
                    player = new CounterTerrorist();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid task: " + task);
            }
            players.put(task, player);
        }

        return player;
    }
}

