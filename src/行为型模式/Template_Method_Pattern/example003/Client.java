package 行为型模式.Template_Method_Pattern.example003;

// 客户端代码
public class Client {
    public static void main(String[] args) {
        Game footballGame = new FootballGame();
        Game basketballGame = new BasketballGame();

        System.out.println("Football Game:");
        footballGame.play();

        System.out.println("\nBasketball Game:");
        basketballGame.play();
    }
}


// 游戏抽象类
abstract class Game {
    // 初始化游戏
    abstract void initialize();

    // 开始游戏
    abstract void startPlay();

    // 结束游戏
    abstract void endPlay();

    // 模板方法，定义游戏流程
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}


// 具体的足球游戏类
class FootballGame extends Game {
    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }
}

// 具体的篮球游戏类
class BasketballGame extends Game {
    @Override
    void initialize() {
        System.out.println("Basketball Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Basketball Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Basketball Game Finished!");
    }
}
